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
 * ObjectMetricStatus indicates the current value of a metric describing a kubernetes object (for example,
 * hits-per-second on an Ingress object).
 */
@Builder
@Jacksonized
@Value
public class ObjectMetricStatus {

    @Nullable
    String averageValue;

    @NonNull
    String currentValue;

    /**
     * metricName is the name of the metric in question.
     */
    @NonNull
    String metricName;

    @Nullable
    LabelSelector selector;

    @NonNull
    CrossVersionObjectReference target;

}
