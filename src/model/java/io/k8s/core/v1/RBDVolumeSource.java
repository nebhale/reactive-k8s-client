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
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Represents a Rados Block Device mount that lasts the lifetime of a pod. RBD volumes support ownership management and
 * SELinux relabeling.
 */
@Builder
@Jacksonized
@Value
public class RBDVolumeSource {

    /**
     * Filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the
     * host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More
     * info: https://kubernetes.io/docs/concepts/storage/volumes#rbd
     */
    @Nullable
    String fsType;

    /**
     * The rados image name. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @NonNull
    String image;

    /**
     * Keyring is the path to key ring for RBDUser. Default is /etc/ceph/keyring. More info:
     * https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @Nullable
    String keyring;

    /**
     * A collection of Ceph monitors. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @NonNull
    @Singular
    List<String> monitors;

    /**
     * The rados pool name. Default is rbd. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @Nullable
    String pool;

    /**
     * ReadOnly here will force the ReadOnly setting in VolumeMounts. Defaults to false. More info:
     * https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @Nullable
    Boolean readOnly;

    @Nullable
    LocalObjectReference secretRef;

    /**
     * The rados user name. Default is admin. More info: https://examples.k8s.io/volumes/rbd/README.md#how-to-use-it
     */
    @Nullable
    String user;

}
