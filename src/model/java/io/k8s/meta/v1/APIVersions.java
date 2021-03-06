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

package io.k8s.meta.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * APIVersions lists the versions that are available, to allow clients to discover the API at /api, which is the root
 * path of the legacy v1 API.
 */
@Builder
@Jacksonized
@Value
public class APIVersions implements TypeMeta {

    public static final String GROUP = "";

    public static final String KIND = "APIVersions";

    public static final String VERSION = "v1";

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized
     * schemas to the latest internal value, and may reject unrecognized values. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @Nullable
    String apiVersion;

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the
     * endpoint the client submits requests to. Cannot be updated. In CamelCase. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @Nullable
    String kind;

    /**
     * a map of client CIDR to server address that is serving this group. This is to help clients reach servers in the
     * most network-efficient way possible. Clients can use the appropriate server address as per the CIDR that they
     * match. In case of multiple matches, clients should use the longest matching CIDR. The server returns only those
     * CIDRs that it thinks that the client can match. For example: the master will return an internal IP CIDR only, if
     * the client reaches the server using an internal IP. Server looks at X-Forwarded-For header or X-Real-Ip header or
     * request.RemoteAddr (in that order) to get the client IP.
     */
    @NonNull
    @Singular
    List<ServerAddressByClientCIDR> serverAddressByClientCIDRs;

    /**
     * versions are the api versions that are available.
     */
    @NonNull
    @Singular
    List<String> versions;

}
