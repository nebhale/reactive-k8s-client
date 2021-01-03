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

import java.time.OffsetDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * HorizontalPodAutoscalerStatus describes the current status of a horizontal pod autoscaler.
 */
@Builder
@Jacksonized
@Value
public class HorizontalPodAutoscalerStatus {

    /**
     * conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or
     * not those conditions are met.
     */
    @NonNull
    @Singular
    List<HorizontalPodAutoscalerCondition> conditions;

    /**
     * currentMetrics is the last read state of the metrics used by this autoscaler.
     */
    @Nullable
    @Singular
    List<MetricStatus> currentMetrics;

    /**
     * currentReplicas is current number of replicas of pods managed by this autoscaler, as last seen by the autoscaler.
     */
    @NonNull
    Integer currentReplicas;

    /**
     * desiredReplicas is the desired number of replicas of pods managed by this autoscaler, as last calculated by the
     * autoscaler.
     */
    @NonNull
    Integer desiredReplicas;

    @Nullable
    OffsetDateTime lastScaleTime;

    /**
     * observedGeneration is the most recent generation observed by this autoscaler.
     */
    @Nullable
    Long observedGeneration;

}
