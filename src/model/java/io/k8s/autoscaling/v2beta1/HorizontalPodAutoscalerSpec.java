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

package io.k8s.autoscaling.v2beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * HorizontalPodAutoscalerSpec describes the desired functionality of the HorizontalPodAutoscaler.
 */
@Builder
@Jacksonized
@Value
public class HorizontalPodAutoscalerSpec {

    /**
     * maxReplicas is the upper limit for the number of replicas to which the autoscaler can scale up. It cannot be less
     * that minReplicas.
     */
    @NonNull
    Integer maxReplicas;

    /**
     * metrics contains the specifications for which to use to calculate the desired replica count (the maximum replica
     * count across all metrics will be used).  The desired replica count is calculated multiplying the ratio between
     * the target value and the current value by the current number of pods.  Ergo, metrics used must decrease as the
     * pod count is increased, and vice-versa.  See the individual metric source types for more information about how
     * each type of metric must respond.
     */
    @Nullable
    @Singular
    List<MetricSpec> metrics;

    /**
     * minReplicas is the lower limit for the number of replicas to which the autoscaler can scale down.  It defaults to
     * 1 pod.  minReplicas is allowed to be 0 if the alpha feature gate HPAScaleToZero is enabled and at least one
     * Object or External metric is configured.  Scaling is active as long as at least one metric value is available.
     */
    @Nullable
    Integer minReplicas;

    @NonNull
    CrossVersionObjectReference scaleTargetRef;

}
