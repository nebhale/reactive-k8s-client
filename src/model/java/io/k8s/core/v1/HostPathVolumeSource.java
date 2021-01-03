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
 * Represents a host path mapped into a pod. Host path volumes do not support ownership management or SELinux
 * relabeling.
 */
@Builder
@Jacksonized
@Value
public class HostPathVolumeSource {

    /**
     * Path of the directory on the host. If the path is a symlink, it will follow the link to the real path. More info:
     * https://kubernetes.io/docs/concepts/storage/volumes#hostpath
     */
    @NonNull
    String path;

    /**
     * Type for HostPath Volume Defaults to "" More info: https://kubernetes.io/docs/concepts/storage/volumes#hostpath
     */
    @Nullable
    String type;

}
