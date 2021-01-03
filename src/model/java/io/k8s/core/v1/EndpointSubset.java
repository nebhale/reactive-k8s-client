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

package io.k8s.core.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * EndpointSubset is a group of addresses with a common set of ports. The expanded set of endpoints is the Cartesian
 * product of Addresses x Ports. For example, given:
 *   {
 *     Addresses: [{"ip": "10.10.1.1"}, {"ip": "10.10.2.2"}],
 *    
 * Ports:     [{"name": "a", "port": 8675}, {"name": "b", "port": 309}]
 *   }
 * The resulting set of endpoints can be viewed
 * as:
 *     a: [ 10.10.1.1:8675, 10.10.2.2:8675 ],
 *     b: [ 10.10.1.1:309, 10.10.2.2:309 ]
 */
@Builder
@Jacksonized
@Value
public class EndpointSubset {

    /**
     * IP addresses which offer the related ports that are marked as ready. These endpoints should be considered safe
     * for load balancers and clients to utilize.
     */
    @Nullable
    @Singular
    List<EndpointAddress> addresses;

    /**
     * IP addresses which offer the related ports but are not currently marked as ready because they have not yet
     * finished starting, have recently failed a readiness check, or have recently failed a liveness check.
     */
    @Nullable
    @Singular
    List<EndpointAddress> notReadyAddresses;

    /**
     * Port numbers available on the related IP addresses.
     */
    @Nullable
    @Singular
    List<EndpointPort> ports;

}
