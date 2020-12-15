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
 * ServicePort contains information on service's port.
 */
@Builder
@Jacksonized
@Value
public class ServicePort {

    /**
     * The application protocol for this port. This field follows standard Kubernetes label syntax. Un-prefixed names
     * are reserved for IANA standard service names (as per RFC-6335 and http://www.iana.org/assignments/service-names).
     * Non-standard protocols should use prefixed names such as mycompany.com/my-custom-protocol. This is a beta field
     * that is guarded by the ServiceAppProtocol feature gate and enabled by default.
     */
    @Nullable
    String appProtocol;

    /**
     * The name of this port within the service. This must be a DNS_LABEL. All ports within a ServiceSpec must have
     * unique names. When considering the endpoints for a Service, this must match the 'name' field in the EndpointPort.
     * Optional if only one ServicePort is defined on this service.
     */
    @Nullable
    String name;

    /**
     * The port on each node on which this service is exposed when type=NodePort or LoadBalancer. Usually assigned by
     * the system. If specified, it will be allocated to the service if unused or else creation of the service will
     * fail. Default is to auto-allocate a port if the ServiceType of this Service requires one. More info:
     * https://kubernetes.io/docs/concepts/services-networking/service/#type-nodeport
     */
    @Nullable
    Integer nodePort;

    /**
     * The port that will be exposed by this service.
     */
    @NonNull
    Integer port;

    /**
     * The IP protocol for this port. Supports "TCP", "UDP", and "SCTP". Default is TCP.
     */
    @Nullable
    String protocol;

    @Nullable
    String targetPort;

}
