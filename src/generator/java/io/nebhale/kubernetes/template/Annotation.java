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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public final class Annotation implements Comparable<Annotation>, Importable {

    @NonNull
    private final Type type;

    @Nullable
    private final String value;

    public Annotation(Type type) {
        this(type, null);
    }

    @Override
    public int compareTo(Annotation o) {
        return type.getName().compareTo(o.type.getName());
    }

    public String getDeclaration() {
        if (value == null) {
            return String.format("@%s", type.getName());
        }

        return String.format("@%s(\"%s\")", type.getName(), value);
    }

    public Type getType() {
        return type;
    }

    @Override
    public List<String> getImportStatements(String _package) {
        return type.getImportStatements(_package);
    }

}
