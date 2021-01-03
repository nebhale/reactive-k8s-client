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

package io.k8s.core.v1;

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * PodCondition contains details for the current condition of this pod.
 */
@Builder
@Jacksonized
@Value
public class PodCondition {

    @Nullable
    OffsetDateTime lastProbeTime;

    @Nullable
    OffsetDateTime lastTransitionTime;

    /**
     * Human-readable message indicating details about last transition.
     */
    @Nullable
    String message;

    /**
     * Unique, one-word, CamelCase reason for the condition's last transition.
     */
    @Nullable
    String reason;

    /**
     * Status is the status of the condition. Can be True, False, Unknown. More info:
     * https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-conditions
     */
    @NonNull
    String status;

    /**
     * Type is the type of the condition. More info:
     * https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#pod-conditions
     */
    @NonNull
    String type;

}
