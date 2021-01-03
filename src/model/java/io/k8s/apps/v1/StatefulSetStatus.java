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

package io.k8s.apps.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * StatefulSetStatus represents the current state of a StatefulSet.
 */
@Builder
@Jacksonized
@Value
public class StatefulSetStatus {

    /**
     * collisionCount is the count of hash collisions for the StatefulSet. The StatefulSet controller uses this field as
     * a collision avoidance mechanism when it needs to create the name for the newest ControllerRevision.
     */
    @Nullable
    Integer collisionCount;

    /**
     * Represents the latest available observations of a statefulset's current state.
     */
    @Nullable
    @Singular
    List<StatefulSetCondition> conditions;

    /**
     * currentReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version
     * indicated by currentRevision.
     */
    @Nullable
    Integer currentReplicas;

    /**
     * currentRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence
     * [0,currentReplicas).
     */
    @Nullable
    String currentRevision;

    /**
     * observedGeneration is the most recent generation observed for this StatefulSet. It corresponds to the
     * StatefulSet's generation, which is updated on mutation by the API Server.
     */
    @Nullable
    Long observedGeneration;

    /**
     * readyReplicas is the number of Pods created by the StatefulSet controller that have a Ready Condition.
     */
    @Nullable
    Integer readyReplicas;

    /**
     * replicas is the number of Pods created by the StatefulSet controller.
     */
    @NonNull
    Integer replicas;

    /**
     * updateRevision, if not empty, indicates the version of the StatefulSet used to generate Pods in the sequence
     * [replicas-updatedReplicas,replicas)
     */
    @Nullable
    String updateRevision;

    /**
     * updatedReplicas is the number of Pods created by the StatefulSet controller from the StatefulSet version
     * indicated by updateRevision.
     */
    @Nullable
    Integer updatedReplicas;

}
