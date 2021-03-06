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
 * Adapts a Secret into a volume.
 * 
 * The contents of the target Secret's Data field will be presented in a volume as files
 * using the keys in the Data field as the file names. Secret volumes support ownership management and SELinux
 * relabeling.
 */
@Builder
@Jacksonized
@Value
public class SecretVolumeSource {

    /**
     * Optional: mode bits used to set permissions on created files by default. Must be an octal value between 0000 and
     * 0777 or a decimal value between 0 and 511. YAML accepts both octal and decimal values, JSON requires decimal
     * values for mode bits. Defaults to 0644. Directories within the path are not affected by this setting. This might
     * be in conflict with other options that affect the file mode, like fsGroup, and the result can be other mode bits
     * set.
     */
    @Nullable
    Integer defaultMode;

    /**
     * If unspecified, each key-value pair in the Data field of the referenced Secret will be projected into the volume
     * as a file whose name is the key and content is the value. If specified, the listed keys will be projected into
     * the specified paths, and unlisted keys will not be present. If a key is specified which is not present in the
     * Secret, the volume setup will error unless it is marked optional. Paths must be relative and may not contain the
     * '..' path or start with '..'.
     */
    @Nullable
    @Singular
    List<KeyToPath> items;

    /**
     * Specify whether the Secret or its keys must be defined
     */
    @Nullable
    Boolean optional;

    /**
     * Name of the secret in the pod's namespace to use. More info:
     * https://kubernetes.io/docs/concepts/storage/volumes#secret
     */
    @Nullable
    String secretName;

}
