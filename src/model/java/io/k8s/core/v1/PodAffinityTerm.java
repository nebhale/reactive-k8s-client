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

import io.k8s.meta.v1.LabelSelector;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Defines a set of pods (namely those matching the labelSelector relative to the given namespace(s)) that this pod
 * should be co-located (affinity) or not co-located (anti-affinity) with, where co-located is defined as running on a
 * node whose value of the label with key <topologyKey> matches that of any node on which a pod of the set of pods is
 * running
 */
@Builder
@Jacksonized
@Value
public class PodAffinityTerm {

    @Nullable
    LabelSelector labelSelector;

    /**
     * namespaces specifies which namespaces the labelSelector applies to (matches against); null or empty list means
     * "this pod's namespace"
     */
    @Nullable
    @Singular
    List<String> namespaces;

    /**
     * This pod should be co-located (affinity) or not co-located (anti-affinity) with the pods matching the
     * labelSelector in the specified namespaces, where co-located is defined as running on a node whose value of the
     * label with key topologyKey matches that of any node on which any of the selected pods is running. Empty
     * topologyKey is not allowed.
     */
    @NonNull
    String topologyKey;

}
