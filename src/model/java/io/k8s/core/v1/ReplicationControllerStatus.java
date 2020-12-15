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

package io.k8s.core.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * ReplicationControllerStatus represents the current status of a replication controller.
 */
@Builder
@Jacksonized
@Value
public class ReplicationControllerStatus {

    /**
     * The number of available replicas (ready for at least minReadySeconds) for this replication controller.
     */
    @Nullable
    Integer availableReplicas;

    /**
     * Represents the latest available observations of a replication controller's current state.
     */
    @Nullable
    @Singular
    List<ReplicationControllerCondition> conditions;

    /**
     * The number of pods that have labels matching the labels of the pod template of the replication controller.
     */
    @Nullable
    Integer fullyLabeledReplicas;

    /**
     * ObservedGeneration reflects the generation of the most recently observed replication controller.
     */
    @Nullable
    Long observedGeneration;

    /**
     * The number of ready replicas for this replication controller.
     */
    @Nullable
    Integer readyReplicas;

    /**
     * Replicas is the most recently oberved number of replicas. More info:
     * https://kubernetes.io/docs/concepts/workloads/controllers/replicationcontroller#what-is-a-replicationcontroller
     */
    @NonNull
    Integer replicas;

}
