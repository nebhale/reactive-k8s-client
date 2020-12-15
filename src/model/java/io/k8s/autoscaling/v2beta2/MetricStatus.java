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

package io.k8s.autoscaling.v2beta2;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * MetricStatus describes the last-read state of a single metric.
 */
@Builder
@Jacksonized
@Value
public class MetricStatus {

    @Nullable
    ExternalMetricStatus external;

    @Nullable
    ObjectMetricStatus object;

    @Nullable
    PodsMetricStatus pods;

    @Nullable
    ResourceMetricStatus resource;

    /**
     * type is the type of metric source.  It will be one of "Object", "Pods" or "Resource", each corresponds to a
     * matching field in the object.
     */
    @NonNull
    String type;

}
