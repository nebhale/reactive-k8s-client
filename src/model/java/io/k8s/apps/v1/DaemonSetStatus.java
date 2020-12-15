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
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * DaemonSetStatus represents the current status of a daemon set.
 */
@Builder
@Jacksonized
@Value
public class DaemonSetStatus {

    /**
     * Count of hash collisions for the DaemonSet. The DaemonSet controller uses this field as a collision avoidance
     * mechanism when it needs to create the name for the newest ControllerRevision.
     */
    @Nullable
    Integer collisionCount;

    /**
     * Represents the latest available observations of a DaemonSet's current state.
     */
    @Nullable
    @Singular
    List<DaemonSetCondition> conditions;

    /**
     * The number of nodes that are running at least 1 daemon pod and are supposed to run the daemon pod. More info:
     * https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @NonNull
    Integer currentNumberScheduled;

    /**
     * The total number of nodes that should be running the daemon pod (including nodes correctly running the daemon
     * pod). More info: https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @NonNull
    Integer desiredNumberScheduled;

    /**
     * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and
     * available (ready for at least spec.minReadySeconds)
     */
    @Nullable
    Integer numberAvailable;

    /**
     * The number of nodes that are running the daemon pod, but are not supposed to run the daemon pod. More info:
     * https://kubernetes.io/docs/concepts/workloads/controllers/daemonset/
     */
    @NonNull
    Integer numberMisscheduled;

    /**
     * The number of nodes that should be running the daemon pod and have one or more of the daemon pod running and
     * ready.
     */
    @NonNull
    Integer numberReady;

    /**
     * The number of nodes that should be running the daemon pod and have none of the daemon pod running and available
     * (ready for at least spec.minReadySeconds)
     */
    @Nullable
    Integer numberUnavailable;

    /**
     * The most recent generation observed by the daemon set controller.
     */
    @Nullable
    Long observedGeneration;

    /**
     * The total number of nodes that are running updated daemon pod
     */
    @Nullable
    Integer updatedNumberScheduled;

}
