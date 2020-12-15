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
 * SeccompProfile defines a pod/container's seccomp profile settings. Only one profile source may be set.
 */
@Builder
@Jacksonized
@Value
public class SeccompProfile {

    /**
     * localhostProfile indicates a profile defined in a file on the node should be used. The profile must be
     * preconfigured on the node to work. Must be a descending path, relative to the kubelet's configured seccomp
     * profile location. Must only be set if type is "Localhost".
     */
    @Nullable
    String localhostProfile;

    /**
     * type indicates which kind of seccomp profile will be applied. Valid options are:
     * 
     * Localhost - a profile defined
     * in a file on the node should be used. RuntimeDefault - the container runtime default profile should be used.
     * Unconfined - no profile should be applied.
     */
    @NonNull
    String type;

}
