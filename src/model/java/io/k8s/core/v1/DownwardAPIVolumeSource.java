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
import org.springframework.lang.Nullable;

/**
 * DownwardAPIVolumeSource represents a volume containing downward API info. Downward API volumes support ownership
 * management and SELinux relabeling.
 */
@Builder
@Jacksonized
@Value
public class DownwardAPIVolumeSource {

    /**
     * Optional: mode bits to use on created files by default. Must be a Optional: mode bits used to set permissions on
     * created files by default. Must be an octal value between 0000 and 0777 or a decimal value between 0 and 511. YAML
     * accepts both octal and decimal values, JSON requires decimal values for mode bits. Defaults to 0644. Directories
     * within the path are not affected by this setting. This might be in conflict with other options that affect the
     * file mode, like fsGroup, and the result can be other mode bits set.
     */
    @Nullable
    Integer defaultMode;

    /**
     * Items is a list of downward API volume file
     */
    @Nullable
    @Singular
    List<DownwardAPIVolumeFile> items;

}
