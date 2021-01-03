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

package io.k8s.node.v1beta1;

import io.k8s.core.v1.Toleration;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * Scheduling specifies the scheduling constraints for nodes supporting a RuntimeClass.
 */
@Builder
@Jacksonized
@Value
public class Scheduling {

    /**
     * nodeSelector lists labels that must be present on nodes that support this RuntimeClass. Pods using this
     * RuntimeClass can only be scheduled to a node matched by this selector. The RuntimeClass nodeSelector is merged
     * with a pod's existing nodeSelector. Any conflicts will cause the pod to be rejected in admission.
     */
    @Nullable
    @Singular("nodeSelector")
    Map<String, String> nodeSelector;

    /**
     * tolerations are appended (excluding duplicates) to pods running with this RuntimeClass during admission,
     * effectively unioning the set of nodes tolerated by the pod and the RuntimeClass.
     */
    @Nullable
    @Singular
    List<Toleration> tolerations;

}
