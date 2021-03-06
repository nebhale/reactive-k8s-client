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

package io.k8s.meta.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * A label selector requirement is a selector that contains values, a key, and an operator that relates the key and
 * values.
 */
@Builder
@Jacksonized
@Value
public class LabelSelectorRequirement {

    /**
     * key is the label key that the selector applies to.
     */
    @NonNull
    String key;

    /**
     * operator represents a key's relationship to a set of values. Valid operators are In, NotIn, Exists and
     * DoesNotExist.
     */
    @NonNull
    String operator;

    /**
     * values is an array of string values. If the operator is In or NotIn, the values array must be non-empty. If the
     * operator is Exists or DoesNotExist, the values array must be empty. This array is replaced during a strategic
     * merge patch.
     */
    @Nullable
    @Singular
    List<String> values;

}
