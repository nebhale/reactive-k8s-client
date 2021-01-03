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
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public final class DefaultType implements Type {

    @NonNull
    private final String name;

    private final boolean isCollection;

    private final boolean isGenerated;

    public DefaultType(java.lang.Class<?> _class) {
        this(_class.getName());
    }

    public DefaultType(String name) {
        this(name, false, false);
    }

    @Override
    public final String getPackage() {
        return name.substring(0, name.lastIndexOf('.'));
    }

    @Override
    public final String getName() {
        return StringUtils.unqualify(name);
    }

    @Override
    public final boolean isCollection() {
        return isCollection;
    }

    public boolean isGenerated() {
        return isGenerated;
    }

    @Override
    public List<String> getImportStatements(String _package) {
        if (getPackage().equals(_package)) {
            return Collections.emptyList();
        }
        return Collections.singletonList(name);
    }

}
