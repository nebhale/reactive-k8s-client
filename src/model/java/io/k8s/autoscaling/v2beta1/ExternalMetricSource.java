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
 * ExternalMetricSource indicates how to scale on a metric not associated with any Kubernetes object (for example length
 * of queue in cloud messaging service, or QPS from loadbalancer running outside of cluster). Exactly one "target" type
 * should be set.
 */
@Builder
@Jacksonized
@Value
public class ExternalMetricSource {

    /**
     * metricName is the name of the metric in question.
     */
    @NonNull
    String metricName;

    @Nullable
    LabelSelector metricSelector;

    @Nullable
    String targetAverageValue;

    @Nullable
    String targetValue;

}
