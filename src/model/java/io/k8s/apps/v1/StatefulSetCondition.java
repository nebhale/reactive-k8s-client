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

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * StatefulSetCondition describes the state of a statefulset at a certain point.
 */
@Builder
@Jacksonized
@Value
public class StatefulSetCondition {

    @Nullable
    OffsetDateTime lastTransitionTime;

    /**
     * A human readable message indicating details about the transition.
     */
    @Nullable
    String message;

    /**
     * The reason for the condition's last transition.
     */
    @Nullable
    String reason;

    /**
     * Status of the condition, one of True, False, Unknown.
     */
    @NonNull
    String status;

    /**
     * Type of statefulset condition.
     */
    @NonNull
    String type;

}
