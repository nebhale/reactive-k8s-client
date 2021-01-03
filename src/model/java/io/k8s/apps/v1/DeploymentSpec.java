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

package io.k8s.apps.v1;

import io.k8s.core.v1.PodTemplateSpec;
import io.k8s.meta.v1.LabelSelector;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * DeploymentSpec is the specification of the desired behavior of the Deployment.
 */
@Builder
@Jacksonized
@Value
public class DeploymentSpec {

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing,
     * for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready)
     */
    @Nullable
    Integer minReadySeconds;

    /**
     * Indicates that the deployment is paused.
     */
    @Nullable
    Boolean paused;

    /**
     * The maximum time in seconds for a deployment to make progress before it is considered to be failed. The
     * deployment controller will continue to process failed deployments and a condition with a ProgressDeadlineExceeded
     * reason will be surfaced in the deployment status. Note that progress will not be estimated during the time a
     * deployment is paused. Defaults to 600s.
     */
    @Nullable
    Integer progressDeadlineSeconds;

    /**
     * Number of desired pods. This is a pointer to distinguish between explicit zero and not specified. Defaults to 1.
     */
    @Nullable
    Integer replicas;

    /**
     * The number of old ReplicaSets to retain to allow rollback. This is a pointer to distinguish between explicit zero
     * and not specified. Defaults to 10.
     */
    @Nullable
    Integer revisionHistoryLimit;

    @NonNull
    LabelSelector selector;

    @Nullable
    DeploymentStrategy strategy;

    @NonNull
    PodTemplateSpec template;

}
