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
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * PersistentVolumeClaimStatus is the current status of a persistent volume claim.
 */
@Builder
@Jacksonized
@Value
public class PersistentVolumeClaimStatus {

    /**
     * AccessModes contains the actual access modes the volume backing the PVC has. More info:
     * https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
     */
    @Nullable
    @Singular
    List<String> accessModes;

    /**
     * Represents the actual resources of the underlying volume.
     */
    @Nullable
    @Singular("capacity")
    Map<String, String> capacity;

    /**
     * Current Condition of persistent volume claim. If underlying persistent volume is being resized then the Condition
     * will be set to 'ResizeStarted'.
     */
    @Nullable
    @Singular
    List<PersistentVolumeClaimCondition> conditions;

    /**
     * Phase represents the current phase of PersistentVolumeClaim.
     */
    @Nullable
    String phase;

}
