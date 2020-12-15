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
import lombok.ToString;
import org.springframework.lang.NonNull;

import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public final class VariableArgumentsType implements Type {

    @NonNull
    private final Type type;

    @Override
    public String getPackage() {
        return type.getPackage();
    }

    @Override
    public String getName() {
        return String.format("%s...", type.getName());
    }

    @Override
    public boolean isCollection() {
        throw new UnsupportedOperationException("a variable arguments type cannot be used where collections are important");
    }

    @Override
    public boolean isGenerated() {
        return type.isGenerated();
    }

    @Override
    public List<String> getImportStatements(String _package) {
        return type.getImportStatements(_package);
    }

}
