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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * PodDNSConfig defines the DNS parameters of a pod in addition to those generated from DNSPolicy.
 */
@Builder
@Jacksonized
@Value
public class PodDNSConfig {

    /**
     * A list of DNS name server IP addresses. This will be appended to the base nameservers generated from DNSPolicy.
     * Duplicated nameservers will be removed.
     */
    @Nullable
    @Singular
    List<String> nameservers;

    /**
     * A list of DNS resolver options. This will be merged with the base options generated from DNSPolicy. Duplicated
     * entries will be removed. Resolution options given in Options will override those that appear in the base
     * DNSPolicy.
     */
    @Nullable
    @Singular
    List<PodDNSConfigOption> options;

    /**
     * A list of DNS search domains for host-name lookup. This will be appended to the base search paths generated from
     * DNSPolicy. Duplicated search paths will be removed.
     */
    @Nullable
    @Singular
    List<String> searches;

}
