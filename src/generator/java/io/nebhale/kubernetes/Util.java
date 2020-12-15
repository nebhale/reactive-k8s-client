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

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.experimental.UtilityClass;
import org.apache.commons.text.CaseUtils;
import org.springframework.util.StringUtils;

import javax.lang.model.SourceVersion;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@UtilityClass
final class Util {

    static Map<String, Object> getSafeExtensions(Operation operation) {
        Map<String, Object> extensions = operation.getExtensions();
        if (extensions == null) {
            return Collections.emptyMap();
        }

        return extensions;
    }

    static Map<String, Object> getSafeExtensions(Schema<?> schema) {
        Map<String, Object> extensions = schema.getExtensions();
        if (extensions == null) {
            return Collections.emptyMap();
        }

        return extensions;
    }

    static String getSafeName(String raw) {
        String name = StringUtils.uncapitalize(raw);

        if (name.contains("-")) {
            name = CaseUtils.toCamelCase(name, false, '-');
        }

        if (name.contains("$")) {
            name = name.replaceAll("\\$", "_");
        }

        if (SourceVersion.isKeyword(name)) {
            name = String.format("_%s", name);
        }

        return name;
    }

    static List<Parameter> getSafeParameters(Operation operation) {
        List<Parameter> parameters = operation.getParameters();
        if (parameters == null) {
            return Collections.emptyList();
        }

        return parameters;
    }

    static List<Parameter> getSafeParameters(PathItem pathItem) {
        List<Parameter> parameters = pathItem.getParameters();
        if (parameters == null) {
            return Collections.emptyList();
        }

        return parameters;
    }

    static Paths getSafePaths(OpenAPI openAPI) {
        Paths paths = openAPI.getPaths();
        if (paths == null) {
            return new Paths();
        }
        return paths;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static Map<String, Schema<?>> getSafeProperties(Schema<?> schema) {
        Map<String, Schema> properties = schema.getProperties();
        if (properties == null) {
            return Collections.emptyMap();
        }

        return properties.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Util.throwingMerger(), LinkedHashMap::new));
    }

    static List<String> getSafeRequired(Schema<?> schema) {
        List<String> required = schema.getRequired();
        if (required == null) {
            return Collections.emptyList();
        }
        return required;
    }

    static ApiResponses getSafeResponses(Operation operation) {
        ApiResponses responses = operation.getResponses();
        if (responses == null) {
            return new ApiResponses();
        }

        return responses;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static Map<String, Schema<?>> getSafeSchemas(OpenAPI openAPI) {
        Map<String, Schema> schemas = openAPI.getComponents().getSchemas();
        if (schemas == null) {
            return Collections.emptyMap();
        }

        return schemas.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Util.throwingMerger(), LinkedHashMap::new));
    }

    List<String> getSafeTags(Operation operation) {
        List<String> tags = operation.getTags();
        if (tags == null) {
            return Collections.emptyList();
        }

        return tags;
    }

    static boolean isDeprecated(String raw) {
        if (raw == null) {
            return false;
        }

        return raw.toLowerCase().contains("deprecate");
    }

    static <T> BinaryOperator<T> throwingMerger() {
        return (u, v) -> {
            throw new IllegalStateException(String.format("Duplicate key %s", u));
        };
    }

}
