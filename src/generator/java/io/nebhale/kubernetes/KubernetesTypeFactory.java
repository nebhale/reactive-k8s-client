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

import io.nebhale.kubernetes.template.DefaultType;
import io.nebhale.kubernetes.template.ListType;
import io.nebhale.kubernetes.template.MapType;
import io.nebhale.kubernetes.template.NeverImportType;
import io.nebhale.kubernetes.template.Type;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Component
@ToString
final class KubernetesTypeFactory implements TypeFactory {

    private static final Pattern KUBERNETES_TYPE = Pattern.compile("(io\\.k8s)\\..*(?:api[s]?|pkg)\\.([a-zA-Z0-9.]+)\\.([a-zA-Z0-9]+)");

    private static final List<String> OBJECTS = Collections.singletonList(
        "io.k8s.apimachinery.pkg.apis.meta.v1.Patch"
    );

    private static final Type BOOLEAN = new NeverImportType(new DefaultType(Boolean.class));

    private static final Type DATE_TIME = new DefaultType(OffsetDateTime.class);

    private static final Type DOUBLE = new NeverImportType(new DefaultType(Double.class));

    private static final Type INTEGER = new NeverImportType(new DefaultType(Integer.class));

    private static final Type INT_OR_STRING = new NeverImportType(new DefaultType(String.class));

    private static final Type LONG = new NeverImportType(new DefaultType(Long.class));

    private static final Type OBJECT = new NeverImportType(new DefaultType(Object.class));

    private static final Type STRING = new NeverImportType(new DefaultType(String.class));

    private final Map<String, Type> aliasedTypes = new ConcurrentHashMap<>();

    @NonNull
    private final OpenAPI openAPI;

    @PostConstruct
    void init() {
        Map<String, Schema<?>> schemas = Util.getSafeSchemas(openAPI);
        schemas.forEach(this::create);
    }

    @Override
    public Type create(Schema<?> schema) {
        Type type = getType(schema);
        if (type != null) {
            return type;
        }

        throw new IllegalArgumentException(String.format("'%s,%s' is not a recognized property type", schema.getType(), schema.getFormat()));
    }

    @Override
    public Type create(String name, Schema<?> schema) {
        Type type = getType(schema);
        if (type != null) {
            aliasedTypes.put(name, type);
            return type;
        }

        if (OBJECTS.contains(name)) {
            aliasedTypes.put(name, KubernetesTypeFactory.OBJECT);
            return KubernetesTypeFactory.OBJECT;
        }

        return new DefaultType(getKubernetesName(name), false, true);
    }

    private String getKubernetesName(String raw) {
        Matcher matcher = KUBERNETES_TYPE.matcher(raw);
        if (!matcher.find()) {
            throw new IllegalArgumentException(String.format("'%s' is not a recognized Kubernetes name", raw));
        }

        return String.format("%s.%s.%s", matcher.group(1), matcher.group(2), matcher.group(3));
    }

    @Nullable
    private Type getType(Schema<?> schema) {
        String type = schema.getType();
        String format = schema.getFormat();

        if ("array".equals(type)) {
            return new ListType(create(((ArraySchema) schema).getItems()));
        }

        if ("boolean".equals(type)) {
            return BOOLEAN;
        }

        if ("string".equals(type)) {
            if (format == null) {
                return STRING;
            }

            if ("byte".equals(format)) {
                return STRING;
            }

            if ("date-time".equals(format)) {
                return DATE_TIME;
            }

            if ("int-or-string".equals(format)) {
                return INT_OR_STRING;
            }

            throw new IllegalArgumentException(String.format("'%s,%s' is not a recognized property type", type, format));
        }

        if ("integer".equals(type)) {
            if (format == null) {
                return INTEGER;
            }

            if ("int32".equals(format)) {
                return INTEGER;
            }

            if ("int64".equals(format)) {
                return LONG;
            }

            throw new IllegalArgumentException(String.format("'%s,%s' is not a recognized property type", type, format));
        }

        if ("number".equals(type)) {
            if ("double".equals(format)) {
                return DOUBLE;
            }

            throw new IllegalArgumentException(String.format("'%s,%s' is not a recognized property type", type, format));
        }

        Object additionalProperties = schema.getAdditionalProperties();
        if (additionalProperties != null && "object".equals(type)) {
            return new MapType(STRING, create((Schema<?>) additionalProperties));
        }

        String ref = schema.get$ref();
        if (ref != null) {
            ref = ref.substring(ref.lastIndexOf('/') + 1);

            Type alias = aliasedTypes.get(ref);
            if (alias != null) {
                return alias;
            }

            return new DefaultType(getKubernetesName(ref), false, true);
        }

        return null;
    }

}

