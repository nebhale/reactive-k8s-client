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
 * PersistentVolumeClaimCondition contails details about state of pvc
 */
@Builder
@Jacksonized
@Value
public class PersistentVolumeClaimCondition {

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
     * Unique, this should be a short, machine understandable string that gives the reason for condition's last
     * transition. If it reports "ResizeStarted" that means the underlying persistent volume is being resized.
     */
    @Nullable
    String reason;

    @NonNull
    String status;

    @NonNull
    String type;

}
