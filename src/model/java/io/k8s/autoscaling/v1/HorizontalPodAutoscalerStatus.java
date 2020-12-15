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

package io.k8s.autoscaling.v1;

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * current status of a horizontal pod autoscaler
 */
@Builder
@Jacksonized
@Value
public class HorizontalPodAutoscalerStatus {

    /**
     * current average CPU utilization over all pods, represented as a percentage of requested CPU, e.g. 70 means that
     * an average pod is using now 70% of its requested CPU.
     */
    @Nullable
    Integer currentCPUUtilizationPercentage;

    /**
     * current number of replicas of pods managed by this autoscaler.
     */
    @NonNull
    Integer currentReplicas;

    /**
     * desired number of replicas of pods managed by this autoscaler.
     */
    @NonNull
    Integer desiredReplicas;

    @Nullable
    OffsetDateTime lastScaleTime;

    /**
     * most recent generation observed by this autoscaler.
     */
    @Nullable
    Long observedGeneration;

}
