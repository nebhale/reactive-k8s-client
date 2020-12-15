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
 * NodeSpec describes the attributes that a node is created with.
 */
@Builder
@Jacksonized
@Value
public class NodeSpec {

    @Nullable
    NodeConfigSource configSource;

    /**
     * PodCIDR represents the pod IP range assigned to the node.
     */
    @Nullable
    String podCIDR;

    /**
     * podCIDRs represents the IP ranges assigned to the node for usage by Pods on that node. If this field is
     * specified, the 0th entry must match the podCIDR field. It may contain at most 1 value for each of IPv4 and IPv6.
     */
    @Nullable
    List<String> podCIDRs;

    /**
     * ID of the node assigned by the cloud provider in the format: <ProviderName>://<ProviderSpecificNodeID>
     */
    @Nullable
    String providerID;

    /**
     * If specified, the node's taints.
     */
    @Nullable
    @Singular
    List<Taint> taints;

    /**
     * Unschedulable controls node schedulability of new pods. By default, node is schedulable. More info:
     * https://kubernetes.io/docs/concepts/nodes/node/#manual-node-administration
     */
    @Nullable
    Boolean unschedulable;

}
