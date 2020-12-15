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

package io.k8s.core.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * A scoped-resource selector requirement is a selector that contains values, a scope name, and an operator that relates
 * the scope name and values.
 */
@Builder
@Jacksonized
@Value
public class ScopedResourceSelectorRequirement {

    /**
     * Represents a scope's relationship to a set of values. Valid operators are In, NotIn, Exists, DoesNotExist.
     */
    @NonNull
    String operator;

    /**
     * The name of the scope that the selector applies to.
     */
    @NonNull
    String scopeName;

    /**
     * An array of string values. If the operator is In or NotIn, the values array must be non-empty. If the operator is
     * Exists or DoesNotExist, the values array must be empty. This array is replaced during a strategic merge patch.
     */
    @Nullable
    @Singular
    List<String> values;

}
