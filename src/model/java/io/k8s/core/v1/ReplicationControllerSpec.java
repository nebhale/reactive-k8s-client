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

import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ReplicationControllerSpec is the specification of a replication controller.
 */
@Builder
@Jacksonized
@Value
public class ReplicationControllerSpec {

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing,
     * for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready)
     */
    @Nullable
    Integer minReadySeconds;

    /**
     * Replicas is the number of desired replicas. This is a pointer to distinguish between explicit zero and
     * unspecified. Defaults to 1. More info:
     * https://kubernetes.io/docs/concepts/workloads/controllers/replicationcontroller#what-is-a-replicationcontroller
     */
    @Nullable
    Integer replicas;

    /**
     * Selector is a label query over pods that should match the Replicas count. If Selector is empty, it is defaulted
     * to the labels present on the Pod template. Label keys and values that must match in order to be controlled by
     * this replication controller, if empty defaulted to labels on Pod template. More info:
     * https://kubernetes.io/docs/concepts/overview/working-with-objects/labels/#label-selectors
     */
    @Nullable
    @Singular("selector")
    Map<String, String> selector;

    @Nullable
    PodTemplateSpec template;

}
