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

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * PersistentVolumeClaimVolumeSource references the user's PVC in the same namespace. This volume finds the bound PV and
 * mounts that volume for the pod. A PersistentVolumeClaimVolumeSource is, essentially, a wrapper around another type of
 * volume that is owned by someone else (the system).
 */
@Builder
@Jacksonized
@Value
public class PersistentVolumeClaimVolumeSource {

    /**
     * ClaimName is the name of a PersistentVolumeClaim in the same namespace as the pod using this volume. More info:
     * https://kubernetes.io/docs/concepts/storage/persistent-volumes#persistentvolumeclaims
     */
    @NonNull
    String claimName;

    /**
     * Will force the ReadOnly setting in VolumeMounts. Default false.
     */
    @Nullable
    Boolean readOnly;

}
