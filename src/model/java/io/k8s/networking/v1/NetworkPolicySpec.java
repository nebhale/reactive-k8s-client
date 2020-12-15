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

import io.k8s.meta.v1.LabelSelector;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * NetworkPolicySpec provides the specification of a NetworkPolicy
 */
@Builder
@Jacksonized
@Value
public class NetworkPolicySpec {

    /**
     * List of egress rules to be applied to the selected pods. Outgoing traffic is allowed if there are no
     * NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic matches at
     * least one egress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is
     * empty then this NetworkPolicy limits all outgoing traffic (and serves solely to ensure that the pods it selects
     * are isolated by default). This field is beta-level in 1.8
     */
    @Nullable
    @Singular("egress")
    List<NetworkPolicyEgressRule> egress;

    /**
     * List of ingress rules to be applied to the selected pods. Traffic is allowed to a pod if there are no
     * NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic source is
     * the pod's local node, OR if the traffic matches at least one ingress rule across all of the NetworkPolicy objects
     * whose podSelector matches the pod. If this field is empty then this NetworkPolicy does not allow any traffic (and
     * serves solely to ensure that the pods it selects are isolated by default)
     */
    @Nullable
    @Singular("ingress")
    List<NetworkPolicyIngressRule> ingress;

    @NonNull
    LabelSelector podSelector;

    /**
     * List of rule types that the NetworkPolicy relates to. Valid options are "Ingress", "Egress", or "Ingress,Egress".
     * If this field is not specified, it will default based on the existence of Ingress or Egress rules; policies that
     * contain an Egress section are assumed to affect Egress, and all policies (whether or not they contain an Ingress
     * section) are assumed to affect Ingress. If you want to write an egress-only policy, you must explicitly specify
     * policyTypes [ "Egress" ]. Likewise, if you want to write a policy that specifies that no egress is allowed, you
     * must specify a policyTypes value that include "Egress" (since such a policy would not include an Egress section
     * and would otherwise default to just [ "Ingress" ]). This field is beta-level in 1.8
     */
    @Nullable
    @Singular
    List<String> policyTypes;

}
