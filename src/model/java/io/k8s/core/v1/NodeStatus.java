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
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * NodeStatus is information about the current status of a node.
 */
@Builder
@Jacksonized
@Value
public class NodeStatus {

    /**
     * List of addresses reachable to the node. Queried from cloud provider, if available. More info:
     * https://kubernetes.io/docs/concepts/nodes/node/#addresses Note: This field is declared as mergeable, but the
     * merge key is not sufficiently unique, which can cause data corruption when it is merged. Callers should instead
     * use a full-replacement patch. See http://pr.k8s.io/79391 for an example.
     */
    @Nullable
    @Singular
    List<NodeAddress> addresses;

    /**
     * Allocatable represents the resources of a node that are available for scheduling. Defaults to Capacity.
     */
    @Nullable
    @Singular("allocatable")
    Map<String, String> allocatable;

    /**
     * Capacity represents the total resources of a node. More info:
     * https://kubernetes.io/docs/concepts/storage/persistent-volumes#capacity
     */
    @Nullable
    @Singular("capacity")
    Map<String, String> capacity;

    /**
     * Conditions is an array of current observed node conditions. More info:
     * https://kubernetes.io/docs/concepts/nodes/node/#condition
     */
    @Nullable
    @Singular
    List<NodeCondition> conditions;

    @Nullable
    NodeConfigStatus config;

    @Nullable
    NodeDaemonEndpoints daemonEndpoints;

    /**
     * List of container images on this node
     */
    @Nullable
    @Singular
    List<ContainerImage> images;

    @Nullable
    NodeSystemInfo nodeInfo;

    /**
     * List of volumes that are attached to the node.
     */
    @Nullable
    @Singular("volumesAttached")
    List<AttachedVolume> volumesAttached;

    /**
     * List of attachable volumes in use (mounted) by the node.
     */
    @Nullable
    @Singular("volumesInUse")
    List<String> volumesInUse;

}
