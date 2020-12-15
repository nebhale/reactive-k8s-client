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

package io.k8s.networking.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * NetworkPolicyIngressRule describes a particular set of traffic that is allowed to the pods matched by a
 * NetworkPolicySpec's podSelector. The traffic must match both ports and from.
 */
@Builder
@Jacksonized
@Value
public class NetworkPolicyIngressRule {

    /**
     * List of sources which should be able to access the pods selected for this rule. Items in this list are combined
     * using a logical OR operation. If this field is empty or missing, this rule matches all sources (traffic not
     * restricted by source). If this field is present and contains at least one item, this rule allows traffic only if
     * the traffic matches at least one item in the from list.
     */
    @Nullable
    @Singular("from")
    List<NetworkPolicyPeer> from;

    /**
     * List of ports which should be made accessible on the pods selected for this rule. Each item in this list is
     * combined using a logical OR. If this field is empty or missing, this rule matches all ports (traffic not
     * restricted by port). If this field is present and contains at least one item, then this rule allows traffic only
     * if the traffic matches at least one port in the list.
     */
    @Nullable
    @Singular
    List<NetworkPolicyPort> ports;

}
