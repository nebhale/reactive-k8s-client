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
 * Represents a Ceph Filesystem mount that lasts the lifetime of a pod Cephfs volumes do not support ownership
 * management or SELinux relabeling.
 */
@Builder
@Jacksonized
@Value
public class CephFSPersistentVolumeSource {

    /**
     * Required: Monitors is a collection of Ceph monitors More info:
     * https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @NonNull
    @Singular
    List<String> monitors;

    /**
     * Optional: Used as the mounted root, rather than the full Ceph tree, default is /
     */
    @Nullable
    String path;

    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts. More
     * info: https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @Nullable
    Boolean readOnly;

    /**
     * Optional: SecretFile is the path to key ring for User, default is /etc/ceph/user.secret More info:
     * https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @Nullable
    String secretFile;

    @Nullable
    SecretReference secretRef;

    /**
     * Optional: User is the rados user name, default is admin More info:
     * https://examples.k8s.io/volumes/cephfs/README.md#how-to-use-it
     */
    @Nullable
    String user;

}
