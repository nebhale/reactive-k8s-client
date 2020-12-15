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

package io.k8s.apiextensions.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CustomResourceSubresourceScale defines how to serve the scale subresource for CustomResources.
 */
@Builder
@Jacksonized
@Value
public class CustomResourceSubresourceScale {

    /**
     * labelSelectorPath defines the JSON path inside of a custom resource that corresponds to Scale `status.selector`.
     * Only JSON paths without the array notation are allowed. Must be a JSON Path under `.status` or `.spec`. Must be
     * set to work with HorizontalPodAutoscaler. The field pointed by this JSON path must be a string field (not a
     * complex selector struct) which contains a serialized label selector in string form. More info:
     * https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions#scale-subresource
     * If there is no value under the given path in the custom resource, the `status.selector` value in the `/scale`
     * subresource will default to the empty string.
     */
    @Nullable
    String labelSelectorPath;

    /**
     * specReplicasPath defines the JSON path inside of a custom resource that corresponds to Scale `spec.replicas`.
     * Only JSON paths without the array notation are allowed. Must be a JSON Path under `.spec`. If there is no value
     * under the given path in the custom resource, the `/scale` subresource will return an error on GET.
     */
    @NonNull
    String specReplicasPath;

    /**
     * statusReplicasPath defines the JSON path inside of a custom resource that corresponds to Scale `status.replicas`.
     * Only JSON paths without the array notation are allowed. Must be a JSON Path under `.status`. If there is no value
     * under the given path in the custom resource, the `status.replicas` value in the `/scale` subresource will default
     * to 0.
     */
    @NonNull
    String statusReplicasPath;

}
