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

import io.k8s.core.v1.PersistentVolumeClaim;
import io.k8s.core.v1.PodTemplateSpec;
import io.k8s.meta.v1.LabelSelector;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * A StatefulSetSpec is the specification of a StatefulSet.
 */
@Builder
@Jacksonized
@Value
public class StatefulSetSpec {

    /**
     * podManagementPolicy controls how pods are created during initial scale up, when replacing pods on nodes, or when
     * scaling down. The default policy is `OrderedReady`, where pods are created in increasing order (pod-0, then
     * pod-1, etc) and the controller will wait until each pod is ready before continuing. When scaling down, the pods
     * are removed in the opposite order. The alternative policy is `Parallel` which will create pods in parallel to
     * match the desired scale without waiting, and on scale down will delete all pods at once.
     */
    @Nullable
    String podManagementPolicy;

    /**
     * replicas is the desired number of replicas of the given Template. These are replicas in the sense that they are
     * instantiations of the same Template, but individual replicas also have a consistent identity. If unspecified,
     * defaults to 1.
     */
    @Nullable
    Integer replicas;

    /**
     * revisionHistoryLimit is the maximum number of revisions that will be maintained in the StatefulSet's revision
     * history. The revision history consists of all revisions not represented by a currently applied StatefulSetSpec
     * version. The default value is 10.
     */
    @Nullable
    Integer revisionHistoryLimit;

    @NonNull
    LabelSelector selector;

    /**
     * serviceName is the name of the service that governs this StatefulSet. This service must exist before the
     * StatefulSet, and is responsible for the network identity of the set. Pods get DNS/hostnames that follow the
     * pattern: pod-specific-string.serviceName.default.svc.cluster.local where "pod-specific-string" is managed by the
     * StatefulSet controller.
     */
    @NonNull
    String serviceName;

    @NonNull
    PodTemplateSpec template;

    @Nullable
    StatefulSetUpdateStrategy updateStrategy;

    /**
     * volumeClaimTemplates is a list of claims that pods are allowed to reference. The StatefulSet controller is
     * responsible for mapping network identities to claims in a way that maintains the identity of a pod. Every claim
     * in this list must have at least one matching (by name) volumeMount in one container in the template. A claim in
     * this list takes precedence over any volumes in the template, with the same name.
     */
    @Nullable
    @Singular
    List<PersistentVolumeClaim> volumeClaimTemplates;

}
