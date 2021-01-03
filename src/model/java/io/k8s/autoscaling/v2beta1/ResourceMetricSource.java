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
 * ResourceMetricSource indicates how to scale on a resource metric known to Kubernetes, as specified in requests and
 * limits, describing each pod in the current scale target (e.g. CPU or memory).  The values will be averaged together
 * before being compared to the target.  Such metrics are built in to Kubernetes, and have special scaling options on
 * top of those available to normal per-pod metrics using the "pods" source.  Only one "target" type should be set.
 */
@Builder
@Jacksonized
@Value
public class ResourceMetricSource {

    /**
     * name is the name of the resource in question.
     */
    @NonNull
    String name;

    /**
     * targetAverageUtilization is the target value of the average of the resource metric across all relevant pods,
     * represented as a percentage of the requested value of the resource for the pods.
     */
    @Nullable
    Integer targetAverageUtilization;

    @Nullable
    String targetAverageValue;

}
