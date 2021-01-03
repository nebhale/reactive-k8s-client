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

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * NodeConfigStatus describes the status of the config assigned by Node.Spec.ConfigSource.
 */
@Builder
@Jacksonized
@Value
public class NodeConfigStatus {

    @Nullable
    NodeConfigSource active;

    @Nullable
    NodeConfigSource assigned;

    /**
     * Error describes any problems reconciling the Spec.ConfigSource to the Active config. Errors may occur, for
     * example, attempting to checkpoint Spec.ConfigSource to the local Assigned record, attempting to checkpoint the
     * payload associated with Spec.ConfigSource, attempting to load or validate the Assigned config, etc. Errors may
     * occur at different points while syncing config. Earlier errors (e.g. download or checkpointing errors) will not
     * result in a rollback to LastKnownGood, and may resolve across Kubelet retries. Later errors (e.g. loading or
     * validating a checkpointed config) will result in a rollback to LastKnownGood. In the latter case, it is usually
     * possible to resolve the error by fixing the config assigned in Spec.ConfigSource. You can find additional
     * information for debugging by searching the error message in the Kubelet log. Error is a human-readable
     * description of the error state; machines can check whether or not Error is empty, but should not rely on the
     * stability of the Error text across Kubelet versions.
     */
    @Nullable
    String error;

    @Nullable
    NodeConfigSource lastKnownGood;

}
