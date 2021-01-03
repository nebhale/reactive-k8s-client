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

package io.k8s.autoscaling.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * specification of a horizontal pod autoscaler.
 */
@Builder
@Jacksonized
@Value
public class HorizontalPodAutoscalerSpec {

    /**
     * upper limit for the number of pods that can be set by the autoscaler; cannot be smaller than MinReplicas.
     */
    @NonNull
    Integer maxReplicas;

    /**
     * minReplicas is the lower limit for the number of replicas to which the autoscaler can scale down.  It defaults to
     * 1 pod.  minReplicas is allowed to be 0 if the alpha feature gate HPAScaleToZero is enabled and at least one
     * Object or External metric is configured.  Scaling is active as long as at least one metric value is available.
     */
    @Nullable
    Integer minReplicas;

    @NonNull
    CrossVersionObjectReference scaleTargetRef;

    /**
     * target average CPU utilization (represented as a percentage of requested CPU) over all the pods; if not specified
     * the default autoscaling policy will be used.
     */
    @Nullable
    Integer targetCPUUtilizationPercentage;

}
