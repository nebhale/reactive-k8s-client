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
import org.springframework.lang.Nullable;

/**
 * LoadBalancerIngress represents the status of a load-balancer ingress point: traffic intended for the service should
 * be sent to an ingress point.
 */
@Builder
@Jacksonized
@Value
public class LoadBalancerIngress {

    /**
     * Hostname is set for load-balancer ingress points that are DNS based (typically AWS load-balancers)
     */
    @Nullable
    String hostname;

    /**
     * IP is set for load-balancer ingress points that are IP based (typically GCE or OpenStack load-balancers)
     */
    @Nullable
    String ip;

}
