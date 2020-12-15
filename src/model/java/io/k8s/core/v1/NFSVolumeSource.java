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
 * Represents an NFS mount that lasts the lifetime of a pod. NFS volumes do not support ownership management or SELinux
 * relabeling.
 */
@Builder
@Jacksonized
@Value
public class NFSVolumeSource {

    /**
     * Path that is exported by the NFS server. More info: https://kubernetes.io/docs/concepts/storage/volumes#nfs
     */
    @NonNull
    String path;

    /**
     * ReadOnly here will force the NFS export to be mounted with read-only permissions. Defaults to false. More info:
     * https://kubernetes.io/docs/concepts/storage/volumes#nfs
     */
    @Nullable
    Boolean readOnly;

    /**
     * Server is the hostname or IP address of the NFS server. More info:
     * https://kubernetes.io/docs/concepts/storage/volumes#nfs
     */
    @NonNull
    String server;

}
