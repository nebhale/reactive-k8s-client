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

import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Represents storage that is managed by an external CSI volume driver (Beta feature)
 */
@Builder
@Jacksonized
@Value
public class CSIPersistentVolumeSource {

    @Nullable
    SecretReference controllerExpandSecretRef;

    @Nullable
    SecretReference controllerPublishSecretRef;

    /**
     * Driver is the name of the driver to use for this volume. Required.
     */
    @NonNull
    String driver;

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs",
     * "ntfs".
     */
    @Nullable
    String fsType;

    @Nullable
    SecretReference nodePublishSecretRef;

    @Nullable
    SecretReference nodeStageSecretRef;

    /**
     * Optional: The value to pass to ControllerPublishVolumeRequest. Defaults to false (read/write).
     */
    @Nullable
    Boolean readOnly;

    /**
     * Attributes of the volume to publish.
     */
    @Nullable
    @Singular
    Map<String, String> volumeAttributes;

    /**
     * VolumeHandle is the unique volume name returned by the CSI volume plugin’s CreateVolume to refer to the volume on
     * all subsequent calls. Required.
     */
    @NonNull
    String volumeHandle;

}
