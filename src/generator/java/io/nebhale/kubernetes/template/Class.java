/*
 * Copyright 2020-2021 the original author or authors.
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

import joptsimple.internal.Strings;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public final class Class {

    @Nullable
    private final String comment;

    @NonNull
    private final Set<Annotation> annotations;

    @NonNull
    private final Type type;

    @NonNull
    private final Set<Type> interfaces;

    @NonNull
    private final List<Constant> constants;

    @NonNull
    private final List<Property> properties;

    public String getPackage() {
        return type.getPackage();
    }

    public List<String> getImportStatements() {
        return Util.getImportStatements(type.getPackage(), annotations, interfaces, properties);
    }

    public List<String> getComment() {
        return Util.getDescription(comment, 117);
    }

    public Set<Annotation> getAnnotations() {
        return new TreeSet<>(annotations);
    }

    public String getName() {
        return type.getName();
    }

    public String getInterfaceNames() {
        return Strings.join(Util.getTypeNames(interfaces), ", ");
    }

    public List<Constant> getConstants() {
        return constants;
    }

    public Set<Type> getInterfaces() {
        return interfaces;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public Type getType() {
        return type;
    }

    public Interface asInterface() {
        List<MethodSignature> methodSignatures = properties.stream()
            .map(Property::asMethodSignature)
            .collect(Collectors.toList());

        return new Interface(comment, type, methodSignatures);
    }

    public Class withAdditionalProperties(List<Property> properties) {
        List<Property> p = Stream.concat(this.properties.stream(), properties.stream())
            .collect(Collectors.toList());

        return new Class(comment, annotations, type, interfaces, constants, p);
    }

}
