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
 * AzureDisk represents an Azure Data Disk mount on the host and bind mount to the pod.
 */
@Builder
@Jacksonized
@Value
public class AzureDiskVolumeSource {

    /**
     * Host Caching mode: None, Read Only, Read Write.
     */
    @Nullable
    String cachingMode;

    /**
     * The Name of the data disk in the blob storage
     */
    @NonNull
    String diskName;

    /**
     * The URI the data disk in the blob storage
     */
    @NonNull
    String diskURI;

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs",
     * "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @Nullable
    String fsType;

    /**
     * Expected values Shared: multiple blob disks per storage account  Dedicated: single blob disk per storage account 
     * Managed: azure managed data disk (only in managed availability set). defaults to shared
     */
    @Nullable
    String kind;

    /**
     * Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @Nullable
    Boolean readOnly;

}
