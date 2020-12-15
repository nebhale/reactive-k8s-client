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

package io.nebhale.kubernetes.template;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public final class Property implements Importable {

    private static final Set<Type> PROPERTY_ONLY_ANNOTATIONS = Collections.singleton(new DefaultType(Singular.class));

    @Nullable
    private final String comment;

    @NonNull
    private final Set<Annotation> annotations;

    @NonNull
    private final Type type;

    @NonNull
    private final String name;

    public List<String> getComment() {
        return Util.getDescription(comment, 113);
    }

    public Set<Annotation> getAnnotations() {
        return new TreeSet<>(annotations);
    }

    public String getTypeName() {
        return type.getName();
    }

    public String getName() {
        return name;
    }

    public List<String> getImportStatements(String _package) {
        return Util.getImportStatements(_package, annotations, Collections.singleton(type));
    }

    public MethodSignature asMethodSignature() {
        String name = this.name;
        if (name.charAt(0) == '_') {
            name = name.substring(1);
        }
        name = String.format("get%s", StringUtils.capitalize(name));

        Set<Annotation> annotations = this.annotations.stream()
            .filter(t -> !PROPERTY_ONLY_ANNOTATIONS.contains(t.getType()))
            .collect(Collectors.toSet());

        return new MethodSignature(comment, annotations, type, name, Collections.emptyList());
    }

}
