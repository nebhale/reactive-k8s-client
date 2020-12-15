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

package io.k8s.networking.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * IngressTLS describes the transport layer security associated with an Ingress.
 */
@Builder
@Jacksonized
@Value
public class IngressTLS {

    /**
     * Hosts are a list of hosts included in the TLS certificate. The values in this list must match the name/s used in
     * the tlsSecret. Defaults to the wildcard host setting for the loadbalancer controller fulfilling this Ingress, if
     * left unspecified.
     */
    @Nullable
    @Singular
    List<String> hosts;

    /**
     * SecretName is the name of the secret used to terminate TLS traffic on port 443. Field is left optional to allow
     * TLS routing based on SNI hostname alone. If the SNI host in a listener conflicts with the "Host" header field
     * used by an IngressRule, the SNI host is used for termination and value of the Host header is used for routing.
     */
    @Nullable
    String secretName;

}
