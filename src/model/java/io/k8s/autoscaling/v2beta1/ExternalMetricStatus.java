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

package io.k8s.autoscaling.v2beta1;

import io.k8s.meta.v1.LabelSelector;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * ExternalMetricStatus indicates the current value of a global metric not associated with any Kubernetes object.
 */
@Builder
@Jacksonized
@Value
public class ExternalMetricStatus {

    @Nullable
    String currentAverageValue;

    @NonNull
    String currentValue;

    /**
     * metricName is the name of a metric used for autoscaling in metric system.
     */
    @NonNull
    String metricName;

    @Nullable
    LabelSelector metricSelector;

}
