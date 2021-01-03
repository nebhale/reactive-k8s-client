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

package io.k8s.core.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * The pod this Toleration is attached to tolerates any taint that matches the triple <key,value,effect> using the
 * matching operator <operator>.
 */
@Builder
@Jacksonized
@Value
public class Toleration {

    /**
     * Effect indicates the taint effect to match. Empty means match all taint effects. When specified, allowed values
     * are NoSchedule, PreferNoSchedule and NoExecute.
     */
    @Nullable
    String effect;

    /**
     * Key is the taint key that the toleration applies to. Empty means match all taint keys. If the key is empty,
     * operator must be Exists; this combination means to match all values and all keys.
     */
    @Nullable
    String key;

    /**
     * Operator represents a key's relationship to the value. Valid operators are Exists and Equal. Defaults to Equal.
     * Exists is equivalent to wildcard for value, so that a pod can tolerate all taints of a particular category.
     */
    @Nullable
    String operator;

    /**
     * TolerationSeconds represents the period of time the toleration (which must be of effect NoExecute, otherwise this
     * field is ignored) tolerates the taint. By default, it is not set, which means tolerate the taint forever (do not
     * evict). Zero and negative values will be treated as 0 (evict immediately) by the system.
     */
    @Nullable
    Long tolerationSeconds;

    /**
     * Value is the taint value the toleration matches to. If the operator is Exists, the value should be empty,
     * otherwise just a regular string.
     */
    @Nullable
    String value;

}
