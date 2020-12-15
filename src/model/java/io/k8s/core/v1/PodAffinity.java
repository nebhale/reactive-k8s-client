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
 * Pod affinity is a group of inter pod affinity scheduling rules.
 */
@Builder
@Jacksonized
@Value
public class PodAffinity {

    /**
     * The scheduler will prefer to schedule pods to nodes that satisfy the affinity expressions specified by this
     * field, but it may choose a node that violates one or more of the expressions. The node that is most preferred is
     * the one with the greatest sum of weights, i.e. for each node that meets all of the scheduling requirements
     * (resource request, requiredDuringScheduling affinity expressions, etc.), compute a sum by iterating through the
     * elements of this field and adding "weight" to the sum if the node has pods which matches the corresponding
     * podAffinityTerm; the node(s) with the highest sum are the most preferred.
     */
    @Nullable
    @Singular("preferredDuringSchedulingIgnoredDuringExecution")
    List<WeightedPodAffinityTerm> preferredDuringSchedulingIgnoredDuringExecution;

    /**
     * If the affinity requirements specified by this field are not met at scheduling time, the pod will not be
     * scheduled onto the node. If the affinity requirements specified by this field cease to be met at some point
     * during pod execution (e.g. due to a pod label update), the system may or may not try to eventually evict the pod
     * from its node. When there are multiple elements, the lists of nodes corresponding to each podAffinityTerm are
     * intersected, i.e. all terms must be satisfied.
     */
    @Nullable
    @Singular("requiredDuringSchedulingIgnoredDuringExecution")
    List<PodAffinityTerm> requiredDuringSchedulingIgnoredDuringExecution;

}
