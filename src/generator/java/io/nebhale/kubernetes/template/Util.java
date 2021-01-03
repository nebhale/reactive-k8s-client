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

import lombok.experimental.UtilityClass;
import org.apache.commons.text.WordUtils;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
final class Util {

    static List<String> getDescription(@Nullable String raw, int width) {
        if (raw == null) {
            return Collections.emptyList();
        }

        String description = raw.replaceAll("\\*/", "&#42;&#47;");
        return Arrays.asList(WordUtils.wrap(description, width).split(System.lineSeparator()));
    }

    @SafeVarargs
    static List<String> getImportStatements(String _package, Collection<? extends Importable>... importables) {
        return Arrays.stream(importables)
            .flatMap(Collection::stream)
            .filter(Objects::nonNull)
            .flatMap(i -> i.getImportStatements(_package).stream())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }

    static List<String> getTypeNames(Collection<Type> types) {
        return types.stream()
            .map(Type::getName)
            .sorted()
            .collect(Collectors.toList());
    }

}
