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

package io.k8s.apps.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * DeploymentStatus is the most recently observed status of the Deployment.
 */
@Builder
@Jacksonized
@Value
public class DeploymentStatus {

    /**
     * Total number of available pods (ready for at least minReadySeconds) targeted by this deployment.
     */
    @Nullable
    Integer availableReplicas;

    /**
     * Count of hash collisions for the Deployment. The Deployment controller uses this field as a collision avoidance
     * mechanism when it needs to create the name for the newest ReplicaSet.
     */
    @Nullable
    Integer collisionCount;

    /**
     * Represents the latest available observations of a deployment's current state.
     */
    @Nullable
    @Singular
    List<DeploymentCondition> conditions;

    /**
     * The generation observed by the deployment controller.
     */
    @Nullable
    Long observedGeneration;

    /**
     * Total number of ready pods targeted by this deployment.
     */
    @Nullable
    Integer readyReplicas;

    /**
     * Total number of non-terminated pods targeted by this deployment (their labels match the selector).
     */
    @Nullable
    Integer replicas;

    /**
     * Total number of unavailable pods targeted by this deployment. This is the total number of pods that are still
     * required for the deployment to have 100% available capacity. They may either be pods that are running but not yet
     * available or pods that still have not been created.
     */
    @Nullable
    Integer unavailableReplicas;

    /**
     * Total number of non-terminated pods targeted by this deployment that have the desired template spec.
     */
    @Nullable
    Integer updatedReplicas;

}
