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
 * Represents a StorageOS persistent volume resource.
 */
@Builder
@Jacksonized
@Value
public class StorageOSPersistentVolumeSource {

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs",
     * "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @Nullable
    String fsType;

    /**
     * Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @Nullable
    Boolean readOnly;

    @Nullable
    ObjectReference secretRef;

    /**
     * VolumeName is the human-readable name of the StorageOS volume.  Volume names are only unique within a namespace.
     */
    @Nullable
    String volumeName;

    /**
     * VolumeNamespace specifies the scope of the volume within StorageOS.  If no namespace is specified then the Pod's
     * namespace will be used.  This allows the Kubernetes name scoping to be mirrored within StorageOS for tighter
     * integration. Set VolumeName to any name to override the default behaviour. Set to "default" if you are not using
     * namespaces within StorageOS. Namespaces that do not pre-exist within StorageOS will be created.
     */
    @Nullable
    String volumeNamespace;

}
