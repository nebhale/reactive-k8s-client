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

package io.k8s.apiextensions.v1beta1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CustomResourceColumnDefinition specifies a column for server side printing.
 */
@Builder
@Jacksonized
@Value
public class CustomResourceColumnDefinition {

    /**
     * JSONPath is a simple JSON path (i.e. with array notation) which is evaluated against each custom resource to
     * produce the value for this column.
     */
    @JsonProperty("JSONPath")
    @NonNull
    String jSONPath;

    /**
     * description is a human readable description of this column.
     */
    @Nullable
    String description;

    /**
     * format is an optional OpenAPI type definition for this column. The 'name' format is applied to the primary
     * identifier column to assist in clients identifying column is the resource name. See
     * https://github.com/OAI/OpenAPI-Specification/blob/master/versions/2.0.md#data-types for details.
     */
    @Nullable
    String format;

    /**
     * name is a human readable name for the column.
     */
    @NonNull
    String name;

    /**
     * priority is an integer defining the relative importance of this column compared to others. Lower numbers are
     * considered higher priority. Columns that may be omitted in limited space scenarios should be given a priority
     * greater than 0.
     */
    @Nullable
    Integer priority;

    /**
     * type is an OpenAPI type definition for this column. See
     * https://github.com/OAI/OpenAPI-Specification/blob/master/versions/2.0.md#data-types for details.
     */
    @NonNull
    String type;

}
