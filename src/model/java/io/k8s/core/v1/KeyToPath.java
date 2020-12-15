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
 * Maps a string key to a path within a volume.
 */
@Builder
@Jacksonized
@Value
public class KeyToPath {

    /**
     * The key to project.
     */
    @NonNull
    String key;

    /**
     * Optional: mode bits used to set permissions on this file. Must be an octal value between 0000 and 0777 or a
     * decimal value between 0 and 511. YAML accepts both octal and decimal values, JSON requires decimal values for
     * mode bits. If not specified, the volume defaultMode will be used. This might be in conflict with other options
     * that affect the file mode, like fsGroup, and the result can be other mode bits set.
     */
    @Nullable
    Integer mode;

    /**
     * The relative path of the file to map the key to. May not be an absolute path. May not contain the path element
     * '..'. May not start with the string '..'.
     */
    @NonNull
    String path;

}
