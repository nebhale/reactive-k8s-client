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

package io.k8s.networking.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * HTTPIngressPath associates a path with a backend. Incoming urls matching the path are forwarded to the backend.
 */
@Builder
@Jacksonized
@Value
public class HTTPIngressPath {

    @NonNull
    IngressBackend backend;

    /**
     * Path is matched against the path of an incoming request. Currently it can contain characters disallowed from the
     * conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. When unspecified, all
     * paths from incoming requests are matched.
     */
    @Nullable
    String path;

    /**
     * PathType determines the interpretation of the Path matching. PathType can be one of the following values: *
     * Exact: Matches the URL path exactly. * Prefix: Matches based on a URL path prefix split by '/'. Matching is
     *  
     * done on a path element by element basis. A path element refers is the
     *   list of labels in the path split by the
     * '/' separator. A request is a
     *   match for path p if every p is an element-wise prefix of p of the
     *   request path.
     * Note that if the last element of the path is a substring
     *   of the last element in request path, it is not a match
     * (e.g. /foo/bar
     *   matches /foo/bar/baz, but does not match /foo/barbaz).
     * * ImplementationSpecific: Interpretation
     * of the Path matching is up to
     *   the IngressClass. Implementations can treat this as a separate PathType
     *   or
     * treat it identically to Prefix or Exact path types.
     * Implementations are required to support all path types.
     * Defaults to ImplementationSpecific.
     */
    @Nullable
    String pathType;

}
