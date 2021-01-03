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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public final class MapType implements Type {

    private static final Type MAP = new DefaultType(Map.class);

    @NonNull
    private final Type keys;

    @NonNull
    private final Type values;

    @Override
    public String getPackage() {
        return MAP.getPackage();
    }

    @Override
    public String getName() {
        return String.format("%s<%s, %s>", MAP.getName(), keys.getName(), values.getName());
    }

    @Override
    public boolean isCollection() {
        return true;
    }

    @Override
    public boolean isGenerated() {
        return false;
    }

    @Override
    public List<String> getImportStatements(String _package) {
        return Util.getImportStatements(_package, Arrays.asList(MAP, keys, values));
    }

}
