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
 * EndpointAddress is a tuple that describes single IP address.
 */
@Builder
@Jacksonized
@Value
public class EndpointAddress {

    /**
     * The Hostname of this endpoint
     */
    @Nullable
    String hostname;

    /**
     * The IP of this endpoint. May not be loopback (127.0.0.0/8), link-local (169.254.0.0/16), or link-local multicast
     * ((224.0.0.0/24). IPv6 is also accepted but not fully supported on all platforms. Also, certain kubernetes
     * components, like kube-proxy, are not IPv6 ready.
     */
    @NonNull
    String ip;

    /**
     * Optional: Node hosting this endpoint. This can be used to determine endpoints local to a node.
     */
    @Nullable
    String nodeName;

    @Nullable
    ObjectReference targetRef;

}
