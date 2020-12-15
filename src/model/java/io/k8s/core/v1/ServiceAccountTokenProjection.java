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
 * ServiceAccountTokenProjection represents a projected service account token volume. This projection can be used to
 * insert a service account token into the pods runtime filesystem for use against APIs (Kubernetes API Server or
 * otherwise).
 */
@Builder
@Jacksonized
@Value
public class ServiceAccountTokenProjection {

    /**
     * Audience is the intended audience of the token. A recipient of a token must identify itself with an identifier
     * specified in the audience of the token, and otherwise should reject the token. The audience defaults to the
     * identifier of the apiserver.
     */
    @Nullable
    String audience;

    /**
     * ExpirationSeconds is the requested duration of validity of the service account token. As the token approaches
     * expiration, the kubelet volume plugin will proactively rotate the service account token. The kubelet will start
     * trying to rotate the token if the token is older than 80 percent of its time to live or if the token is older
     * than 24 hours.Defaults to 1 hour and must be at least 10 minutes.
     */
    @Nullable
    Long expirationSeconds;

    /**
     * Path is the path relative to the mount point of the file to project the token into.
     */
    @NonNull
    String path;

}
