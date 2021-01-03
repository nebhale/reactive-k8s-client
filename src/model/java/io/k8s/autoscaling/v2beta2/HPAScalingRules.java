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

package io.k8s.autoscaling.v2beta2;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * HPAScalingRules configures the scaling behavior for one direction. These Rules are applied after calculating
 * DesiredReplicas from metrics for the HPA. They can limit the scaling velocity by specifying scaling policies. They
 * can prevent flapping by specifying the stabilization window, so that the number of replicas is not set instantly,
 * instead, the safest value from the stabilization window is chosen.
 */
@Builder
@Jacksonized
@Value
public class HPAScalingRules {

    /**
     * policies is a list of potential scaling polices which can be used during scaling. At least one policy must be
     * specified, otherwise the HPAScalingRules will be discarded as invalid
     */
    @Nullable
    @Singular
    List<HPAScalingPolicy> policies;

    /**
     * selectPolicy is used to specify which policy should be used. If not set, the default value MaxPolicySelect is
     * used.
     */
    @Nullable
    String selectPolicy;

    /**
     * StabilizationWindowSeconds is the number of seconds for which past recommendations should be considered while
     * scaling up or scaling down. StabilizationWindowSeconds must be greater than or equal to zero and less than or
     * equal to 3600 (one hour). If not set, use the default values: - For scale up: 0 (i.e. no stabilization is done).
     * - For scale down: 300 (i.e. the stabilization window is 300 seconds long).
     */
    @Nullable
    Integer stabilizationWindowSeconds;

}
