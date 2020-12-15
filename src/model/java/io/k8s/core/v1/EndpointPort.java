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
 * EndpointPort is a tuple that describes a single port.
 */
@Builder
@Jacksonized
@Value
public class EndpointPort {

    /**
     * The application protocol for this port. This field follows standard Kubernetes label syntax. Un-prefixed names
     * are reserved for IANA standard service names (as per RFC-6335 and http://www.iana.org/assignments/service-names).
     * Non-standard protocols should use prefixed names such as mycompany.com/my-custom-protocol. This is a beta field
     * that is guarded by the ServiceAppProtocol feature gate and enabled by default.
     */
    @Nullable
    String appProtocol;

    /**
     * The name of this port.  This must match the 'name' field in the corresponding ServicePort. Must be a DNS_LABEL.
     * Optional only if one port is defined.
     */
    @Nullable
    String name;

    /**
     * The port number of the endpoint.
     */
    @NonNull
    Integer port;

    /**
     * The IP protocol for this port. Must be UDP, TCP, or SCTP. Default is TCP.
     */
    @Nullable
    String protocol;

}
