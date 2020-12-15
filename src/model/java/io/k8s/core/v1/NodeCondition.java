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

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * NodeCondition contains condition information for a node.
 */
@Builder
@Jacksonized
@Value
public class NodeCondition {

    @Nullable
    OffsetDateTime lastHeartbeatTime;

    @Nullable
    OffsetDateTime lastTransitionTime;

    /**
     * Human readable message indicating details about last transition.
     */
    @Nullable
    String message;

    /**
     * (brief) reason for the condition's last transition.
     */
    @Nullable
    String reason;

    /**
     * Status of the condition, one of True, False, Unknown.
     */
    @NonNull
    String status;

    /**
     * Type of node condition.
     */
    @NonNull
    String type;

}
