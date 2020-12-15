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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * LimitRangeItem defines a min/max usage limit for any resource that matches on kind.
 */
@Builder
@Jacksonized
@Value
public class LimitRangeItem {

    /**
     * Default resource requirement limit value by resource name if resource limit is omitted.
     */
    @JsonProperty("default")
    @Nullable
    @Singular("_default")
    Map<String, String> _default;

    /**
     * DefaultRequest is the default resource requirement request value by resource name if resource request is omitted.
     */
    @Nullable
    @Singular("defaultRequest")
    Map<String, String> defaultRequest;

    /**
     * Max usage constraints on this kind by resource name.
     */
    @Nullable
    @Singular("max")
    Map<String, String> max;

    /**
     * MaxLimitRequestRatio if specified, the named resource must have a request and limit that are both non-zero where
     * limit divided by request is less than or equal to the enumerated value; this represents the max burst for the
     * named resource.
     */
    @Nullable
    @Singular("maxLimitRequestRatio")
    Map<String, String> maxLimitRequestRatio;

    /**
     * Min usage constraints on this kind by resource name.
     */
    @Nullable
    @Singular("min")
    Map<String, String> min;

    /**
     * Type of resource that this limit applies to.
     */
    @NonNull
    String type;

}
