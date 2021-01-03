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

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

/**
 * HPAScalingPolicy is a single policy which must hold true for a specified past interval.
 */
@Builder
@Jacksonized
@Value
public class HPAScalingPolicy {

    /**
     * PeriodSeconds specifies the window of time for which the policy should hold true. PeriodSeconds must be greater
     * than zero and less than or equal to 1800 (30 min).
     */
    @NonNull
    Integer periodSeconds;

    /**
     * Type is used to specify the scaling policy.
     */
    @NonNull
    String type;

    /**
     * Value contains the amount of change which is permitted by the policy. It must be greater than zero
     */
    @NonNull
    Integer value;

}
