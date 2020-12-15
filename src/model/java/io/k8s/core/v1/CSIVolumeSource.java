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

import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Represents a source location of a volume to mount, managed by an external CSI driver
 */
@Builder
@Jacksonized
@Value
public class CSIVolumeSource {

    /**
     * Driver is the name of the CSI driver that handles this volume. Consult with your admin for the correct name as
     * registered in the cluster.
     */
    @NonNull
    String driver;

    /**
     * Filesystem type to mount. Ex. "ext4", "xfs", "ntfs". If not provided, the empty value is passed to the associated
     * CSI driver which will determine the default filesystem to apply.
     */
    @Nullable
    String fsType;

    @Nullable
    LocalObjectReference nodePublishSecretRef;

    /**
     * Specifies a read-only configuration for the volume. Defaults to false (read/write).
     */
    @Nullable
    Boolean readOnly;

    /**
     * VolumeAttributes stores driver-specific properties that are passed to the CSI driver. Consult your driver's
     * documentation for supported values.
     */
    @Nullable
    @Singular
    Map<String, String> volumeAttributes;

}
