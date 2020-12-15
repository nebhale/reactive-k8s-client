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
 * Represents a vSphere volume resource.
 */
@Builder
@Jacksonized
@Value
public class VsphereVirtualDiskVolumeSource {

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs",
     * "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @Nullable
    String fsType;

    /**
     * Storage Policy Based Management (SPBM) profile ID associated with the StoragePolicyName.
     */
    @Nullable
    String storagePolicyID;

    /**
     * Storage Policy Based Management (SPBM) profile name.
     */
    @Nullable
    String storagePolicyName;

    /**
     * Path that identifies vSphere volume vmdk
     */
    @NonNull
    String volumePath;

}
