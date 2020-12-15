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
 * Local represents directly-attached storage with node affinity (Beta feature)
 */
@Builder
@Jacksonized
@Value
public class LocalVolumeSource {

    /**
     * Filesystem type to mount. It applies only when the Path is a block device. Must be a filesystem type supported by
     * the host operating system. Ex. "ext4", "xfs", "ntfs". The default value is to auto-select a fileystem if
     * unspecified.
     */
    @Nullable
    String fsType;

    /**
     * The full path to the volume on the node. It can be either a directory or block device (disk, partition, ...).
     */
    @NonNull
    String path;

}
