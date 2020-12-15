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

package io.k8s.discovery.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * EndpointPort represents a Port used by an EndpointSlice
 */
@Builder
@Jacksonized
@Value
public class EndpointPort {

    /**
     * The application protocol for this port. This field follows standard Kubernetes label syntax. Un-prefixed names
     * are reserved for IANA standard service names (as per RFC-6335 and http://www.iana.org/assignments/service-names).
     * Non-standard protocols should use prefixed names such as mycompany.com/my-custom-protocol.
     */
    @Nullable
    String appProtocol;

    /**
     * The name of this port. All ports in an EndpointSlice must have a unique name. If the EndpointSlice is dervied
     * from a Kubernetes service, this corresponds to the Service.ports[].name. Name must either be an empty string or
     * pass DNS_LABEL validation: * must be no more than 63 characters long. * must consist of lower case alphanumeric
     * characters or '-'. * must start and end with an alphanumeric character. Default is empty string.
     */
    @Nullable
    String name;

    /**
     * The port number of the endpoint. If this is not specified, ports are not restricted and must be interpreted in
     * the context of the specific consumer.
     */
    @Nullable
    Integer port;

    /**
     * The IP protocol for this port. Must be UDP, TCP, or SCTP. Default is TCP.
     */
    @Nullable
    String protocol;

}
