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

import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * FlexPersistentVolumeSource represents a generic persistent volume resource that is provisioned/attached using an exec
 * based plugin.
 */
@Builder
@Jacksonized
@Value
public class FlexPersistentVolumeSource {

    /**
     * Driver is the name of the driver to use for this volume.
     */
    @NonNull
    String driver;

    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs",
     * "ntfs". The default filesystem depends on FlexVolume script.
     */
    @Nullable
    String fsType;

    /**
     * Optional: Extra command options if any.
     */
    @Nullable
    @Singular
    Map<String, String> options;

    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts.
     */
    @Nullable
    Boolean readOnly;

    @Nullable
    SecretReference secretRef;

}
