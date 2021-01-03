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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * Represents a Fibre Channel volume. Fibre Channel volumes can only be mounted as read/write once. Fibre Channel
 * volumes support ownership management and SELinux relabeling.
 */
@Builder
@Jacksonized
@Value
public class FCVolumeSource {

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs",
     * "ntfs". Implicitly inferred to be "ext4" if unspecified.
     */
    @Nullable
    String fsType;

    /**
     * Optional: FC target lun number
     */
    @Nullable
    Integer lun;

    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @Nullable
    Boolean readOnly;

    /**
     * Optional: FC target worldwide names (WWNs)
     */
    @Nullable
    @Singular
    List<String> targetWWNs;

    /**
     * Optional: FC volume world wide identifiers (wwids) Either wwids or combination of targetWWNs and lun must be set,
     * but not both simultaneously.
     */
    @Nullable
    @Singular
    List<String> wwids;

}
