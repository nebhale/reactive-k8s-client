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
 * Node affinity is a group of node affinity scheduling rules.
 */
@Builder
@Jacksonized
@Value
public class NodeAffinity {

    /**
     * The scheduler will prefer to schedule pods to nodes that satisfy the affinity expressions specified by this
     * field, but it may choose a node that violates one or more of the expressions. The node that is most preferred is
     * the one with the greatest sum of weights, i.e. for each node that meets all of the scheduling requirements
     * (resource request, requiredDuringScheduling affinity expressions, etc.), compute a sum by iterating through the
     * elements of this field and adding "weight" to the sum if the node matches the corresponding matchExpressions; the
     * node(s) with the highest sum are the most preferred.
     */
    @Nullable
    @Singular("preferredDuringSchedulingIgnoredDuringExecution")
    List<PreferredSchedulingTerm> preferredDuringSchedulingIgnoredDuringExecution;

    @Nullable
    NodeSelector requiredDuringSchedulingIgnoredDuringExecution;

}
