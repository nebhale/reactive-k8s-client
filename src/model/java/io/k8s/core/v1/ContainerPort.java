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
 * ContainerPort represents a network port in a single container.
 */
@Builder
@Jacksonized
@Value
public class ContainerPort {

    /**
     * Number of port to expose on the pod's IP address. This must be a valid port number, 0 < x < 65536.
     */
    @NonNull
    Integer containerPort;

    /**
     * What host IP to bind the external port to.
     */
    @Nullable
    String hostIP;

    /**
     * Number of port to expose on the host. If specified, this must be a valid port number, 0 < x < 65536. If
     * HostNetwork is specified, this must match ContainerPort. Most containers do not need this.
     */
    @Nullable
    Integer hostPort;

    /**
     * If specified, this must be an IANA_SVC_NAME and unique within the pod. Each named port in a pod must have a
     * unique name. Name for the port that can be referred to by services.
     */
    @Nullable
    String name;

    /**
     * Protocol for port. Must be UDP, TCP, or SCTP. Defaults to "TCP".
     */
    @Nullable
    String protocol;

}
