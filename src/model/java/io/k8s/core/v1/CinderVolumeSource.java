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
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Represents a cinder volume resource in Openstack. A Cinder volume must exist before mounting to a container. The
 * volume must also be in the same region as the kubelet. Cinder volumes support ownership management and SELinux
 * relabeling.
 */
@Builder
@Jacksonized
@Value
public class CinderVolumeSource {

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Examples: "ext4",
     * "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info:
     * https://examples.k8s.io/mysql-cinder-pd/README.md
     */
    @Nullable
    String fsType;

    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts. More
     * info: https://examples.k8s.io/mysql-cinder-pd/README.md
     */
    @Nullable
    Boolean readOnly;

    @Nullable
    LocalObjectReference secretRef;

    /**
     * volume id used to identify the volume in cinder. More info: https://examples.k8s.io/mysql-cinder-pd/README.md
     */
    @NonNull
    String volumeID;

}
