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

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * ResourceMetricStatus indicates the current value of a resource metric known to Kubernetes, as specified in requests
 * and limits, describing each pod in the current scale target (e.g. CPU or memory).  Such metrics are built in to
 * Kubernetes, and have special scaling options on top of those available to normal per-pod metrics using the "pods"
 * source.
 */
@Builder
@Jacksonized
@Value
public class ResourceMetricStatus {

    /**
     * currentAverageUtilization is the current value of the average of the resource metric across all relevant pods,
     * represented as a percentage of the requested value of the resource for the pods.  It will only be present if
     * `targetAverageValue` was set in the corresponding metric specification.
     */
    @Nullable
    Integer currentAverageUtilization;

    @NonNull
    String currentAverageValue;

    /**
     * name is the name of the resource in question.
     */
    @NonNull
    String name;

}
