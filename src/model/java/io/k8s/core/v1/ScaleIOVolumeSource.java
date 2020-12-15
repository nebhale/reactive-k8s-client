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
 * ScaleIOVolumeSource represents a persistent ScaleIO volume
 */
@Builder
@Jacksonized
@Value
public class ScaleIOVolumeSource {

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs",
     * "ntfs". Default is "xfs".
     */
    @Nullable
    String fsType;

    /**
     * The host address of the ScaleIO API Gateway.
     */
    @NonNull
    String gateway;

    /**
     * The name of the ScaleIO Protection Domain for the configured storage.
     */
    @Nullable
    String protectionDomain;

    /**
     * Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @Nullable
    Boolean readOnly;

    @NonNull
    LocalObjectReference secretRef;

    /**
     * Flag to enable/disable SSL communication with Gateway, default false
     */
    @Nullable
    Boolean sslEnabled;

    /**
     * Indicates whether the storage for a volume should be ThickProvisioned or ThinProvisioned. Default is
     * ThinProvisioned.
     */
    @Nullable
    String storageMode;

    /**
     * The ScaleIO Storage Pool associated with the protection domain.
     */
    @Nullable
    String storagePool;

    /**
     * The name of the storage system as configured in ScaleIO.
     */
    @NonNull
    String system;

    /**
     * The name of a volume already created in the ScaleIO system that is associated with this volume source.
     */
    @Nullable
    String volumeName;

}
