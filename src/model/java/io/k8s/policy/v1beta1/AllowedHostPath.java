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

package io.k8s.policy.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * AllowedHostPath defines the host volume conditions that will be enabled by a policy for pods to use. It requires the
 * path prefix to be defined.
 */
@Builder
@Jacksonized
@Value
public class AllowedHostPath {

    /**
     * pathPrefix is the path prefix that the host volume must match. It does not support `*`. Trailing slashes are
     * trimmed when validating the path prefix with a host path.
     * 
     * Examples: `/foo` would allow `/foo`, `/foo/` and
     * `/foo/bar` `/foo` would not allow `/food` or `/etc/foo`
     */
    @Nullable
    String pathPrefix;

    /**
     * when set to true, will allow host volumes matching the pathPrefix only if all volume mounts are readOnly.
     */
    @Nullable
    Boolean readOnly;

}
