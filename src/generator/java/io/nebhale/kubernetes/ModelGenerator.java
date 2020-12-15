/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.nebhale.kubernetes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mustachejava.MustacheFactory;
import io.k8s.meta.v1.TypeMeta;
import io.nebhale.kubernetes.generator.ClassGenerator;
import io.nebhale.kubernetes.generator.CompositeGenerator;
import io.nebhale.kubernetes.generator.Generator;
import io.nebhale.kubernetes.generator.InterfaceGenerator;
import io.nebhale.kubernetes.generator.NoOpGenerator;
import io.nebhale.kubernetes.generator.PackageGenerator;
import io.nebhale.kubernetes.template.Annotation;
import io.nebhale.kubernetes.template.Class;
import io.nebhale.kubernetes.template.Constant;
import io.nebhale.kubernetes.template.DefaultType;
import io.nebhale.kubernetes.template.Property;
import io.nebhale.kubernetes.template.Type;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.extern.jackson.Jacksonized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
@Order(1)
final class ModelGenerator implements CommandLineRunner {

    private static final Set<Annotation> ANNOTATIONS = new HashSet<>(Arrays.asList(
        new Annotation(new DefaultType(Builder.class)),
        new Annotation(new DefaultType(Jacksonized.class)),
        new Annotation(new DefaultType(lombok.Value.class))
    ));

    private static final List<String> METAS = Arrays.asList(
        "io.k8s.apimachinery.pkg.apis.meta.v1.ListMeta",
        "io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta"
    );

    private static final Pattern PLURALS = Pattern.compile(".+[^s]s$");

    private static final Set<String> SINGULAR_EXCEPTIONS = Collections.singleton("podCIDRs");

    private static final Type JSON_PROPERTY = new DefaultType(JsonProperty.class);

    private static final Annotation NON_NULL = new Annotation(new DefaultType(NonNull.class));

    private static final Annotation NULLABLE = new Annotation(new DefaultType(Nullable.class));

    private static final Type SINGULAR = new DefaultType(Singular.class);

    private static final Type TYPE_META = new DefaultType(TypeMeta.class);

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @NonNull
    private final MustacheFactory mustacheFactory;

    @NonNull
    private final OpenAPI openAPI;

    @NonNull
    @Value("${model}")
    private final Path path;

    @NonNull
    private final TypeFactory typeFactory;

    @Override
    public void run(String... args) throws IOException {
        Map<String, Schema<?>> schemas = Util.getSafeSchemas(openAPI);
        Map<Type, Class> metas = getMetas(schemas);

        List<Generator> generators = schemas.entrySet().stream()
            .map(e -> getGenerator(e.getKey(), e.getValue(), metas))
            .collect(Collectors.toList());

        if (FileSystemUtils.deleteRecursively(path)) {
            logger.warn("Deleted {}", path);
        }

        for (Generator g : generators) {
            g.writeTo(path);
        }
    }

    private Class getClass(String name, Schema<?> schema) {
        return new Class(schema.getDescription(), ANNOTATIONS, typeFactory.create(name, schema), getInterfaces(schema),
            getConstants(schema), getProperties(schema));
    }

    @SuppressWarnings("unchecked")
    private List<Constant> getConstants(Schema<?> schema) {
        Object gvk = Util.getSafeExtensions(schema).get("x-kubernetes-group-version-kind");
        if (gvk == null) {
            return Collections.emptyList();
        }

        return ((List<Map<String, String>>) gvk).stream()
            .limit(1)
            .flatMap(m -> m.entrySet().stream())
            .map(e -> new Constant(e.getKey(), e.getValue()))
            .collect(Collectors.toList());
    }

    private Generator getGenerator(String name, Schema<?> schema, Map<Type, Class> metas) {
        Class _class = getClass(name, schema);
        if (!_class.getType().isGenerated()) {
            return NoOpGenerator.INSTANCE;
        }

        Generator packageGenerator = new PackageGenerator(_class.getType().getPackage(), mustacheFactory);

        if (metas.containsKey(_class.getType())) {
            return new CompositeGenerator(packageGenerator, new InterfaceGenerator(_class.asInterface(), mustacheFactory));
        }

        for (Type t : _class.getInterfaces()) {
            Class meta = metas.get(t);
            if (meta != null) {
                _class = _class.withAdditionalProperties(meta.getProperties());
            }
        }

        return new CompositeGenerator(packageGenerator, new ClassGenerator(_class, mustacheFactory));
    }

    private Set<Type> getInterfaces(Schema<?> schema) {
        Set<Type> interfaces = new HashSet<>();

        Map<String, Schema<?>> properties = Util.getSafeProperties(schema);

        Schema<?> metadata = properties.get("metadata");
        if (metadata != null) {
            interfaces.add(typeFactory.create(metadata));
        }

        if (properties.containsKey("kind") && properties.containsKey("apiVersion")) {
            interfaces.add(TYPE_META);
        }

        return interfaces;
    }

    private Map<Type, Class> getMetas(Map<String, Schema<?>> schemas) {
        return METAS.stream()
            .map(m -> getClass(m, schemas.get(m)))
            .collect(Collectors.toMap(Class::getType, Function.identity()));
    }

    private List<Property> getProperties(Schema<?> schema) {
        Map<String, Schema<?>> properties = Util.getSafeProperties(schema);
        if (properties == null) {
            return Collections.emptyList();
        }

        List<String> required = Util.getSafeRequired(schema);

        return properties.entrySet().stream()
            .filter(e -> !"metadata".equals(e.getKey()) && !Util.isDeprecated(e.getValue().getDescription()))
            .map(e -> getProperty(e.getKey(), e.getValue(), required.contains(e.getKey())))
            .collect(Collectors.toList());
    }

    private Property getProperty(String name, Schema<?> schema, boolean required) {
        Type type = typeFactory.create(schema);

        Set<Annotation> annotations = new HashSet<>();
        annotations.add(required ? NON_NULL : NULLABLE);

        String safeName = Util.getSafeName(name);
        if (!name.equals(safeName)) {
            annotations.add(new Annotation(JSON_PROPERTY, name));
        }

        if (type.isCollection() && !SINGULAR_EXCEPTIONS.contains(name)) {
            annotations.add(new Annotation(SINGULAR, PLURALS.matcher(name).find() ? null : safeName));
        }

        return new Property(schema.getDescription(), annotations, type, safeName);
    }

}
