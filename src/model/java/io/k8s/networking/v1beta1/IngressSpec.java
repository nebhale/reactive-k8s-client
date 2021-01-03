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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * IngressSpec describes the Ingress the user wishes to exist.
 */
@Builder
@Jacksonized
@Value
public class IngressSpec {

    @Nullable
    IngressBackend backend;

    /**
     * A list of host rules used to configure the Ingress. If unspecified, or no rule matches, all traffic is sent to
     * the default backend.
     */
    @Nullable
    @Singular
    List<IngressRule> rules;

    /**
     * TLS configuration. Currently the Ingress only supports a single TLS port, 443. If multiple members of this list
     * specify different hosts, they will be multiplexed on the same port according to the hostname specified through
     * the SNI TLS extension, if the ingress controller fulfilling the ingress supports SNI.
     */
    @Nullable
    @Singular
    List<IngressTLS> tls;

}
