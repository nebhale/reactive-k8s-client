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
 * VolumeMount describes a mounting of a Volume within a container.
 */
@Builder
@Jacksonized
@Value
public class VolumeMount {

    /**
     * Path within the container at which the volume should be mounted.  Must not contain ':'.
     */
    @NonNull
    String mountPath;

    /**
     * mountPropagation determines how mounts are propagated from the host to container and the other way around. When
     * not set, MountPropagationNone is used. This field is beta in 1.10.
     */
    @Nullable
    String mountPropagation;

    /**
     * This must match the Name of a Volume.
     */
    @NonNull
    String name;

    /**
     * Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
     */
    @Nullable
    Boolean readOnly;

    /**
     * Path within the volume from which the container's volume should be mounted. Defaults to "" (volume's root).
     */
    @Nullable
    String subPath;

    /**
     * Expanded path within the volume from which the container's volume should be mounted. Behaves similarly to SubPath
     * but environment variable references $(VAR_NAME) are expanded using the container's environment. Defaults to ""
     * (volume's root). SubPathExpr and SubPath are mutually exclusive.
     */
    @Nullable
    String subPathExpr;

}
