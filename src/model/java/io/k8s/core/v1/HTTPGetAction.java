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
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * HTTPGetAction describes an action based on HTTP Get requests.
 */
@Builder
@Jacksonized
@Value
public class HTTPGetAction {

    /**
     * Host name to connect to, defaults to the pod IP. You probably want to set "Host" in httpHeaders instead.
     */
    @Nullable
    String host;

    /**
     * Custom headers to set in the request. HTTP allows repeated headers.
     */
    @Nullable
    @Singular
    List<HTTPHeader> httpHeaders;

    /**
     * Path to access on the HTTP server.
     */
    @Nullable
    String path;

    @NonNull
    String port;

    /**
     * Scheme to use for connecting to the host. Defaults to HTTP.
     */
    @Nullable
    String scheme;

}
