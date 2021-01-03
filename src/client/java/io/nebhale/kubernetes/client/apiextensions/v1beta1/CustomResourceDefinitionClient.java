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

package io.nebhale.kubernetes.client.apiextensions.v1beta1;

import io.k8s.apiextensions.v1beta1.CustomResourceDefinition;
import io.k8s.apiextensions.v1beta1.CustomResourceDefinitionList;
import io.k8s.meta.v1.CreateOptions;
import io.k8s.meta.v1.DeleteOptions;
import io.k8s.meta.v1.GetOptions;
import io.k8s.meta.v1.ListOptions;
import io.k8s.meta.v1.PatchOptions;
import io.k8s.meta.v1.Status;
import io.k8s.meta.v1.UpdateOptions;
import io.k8s.type.PatchType;
import reactor.core.publisher.Mono;

public interface CustomResourceDefinitionClient {

    /**
     * create a CustomResourceDefinition
     */
    Mono<CustomResourceDefinition> create(CustomResourceDefinition body, CreateOptions options);

    /**
     * delete a CustomResourceDefinition
     */
    Mono<Status> delete(String name, DeleteOptions body);

    /**
     * delete collection of CustomResourceDefinition
     */
    Mono<Status> deleteCollection(DeleteOptions body, ListOptions options);

    /**
     * read the specified CustomResourceDefinition
     */
    Mono<CustomResourceDefinition> get(String name, GetOptions options);

    /**
     * read status of the specified CustomResourceDefinition
     */
    Mono<CustomResourceDefinition> getStatus(String name, GetOptions options);

    /**
     * list or watch objects of kind CustomResourceDefinition
     */
    Mono<CustomResourceDefinitionList> list(ListOptions options);

    /**
     * partially update the specified CustomResourceDefinition
     */
    Mono<CustomResourceDefinition> patch(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * partially update status of the specified CustomResourceDefinition
     */
    Mono<CustomResourceDefinition> patchStatus(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * replace the specified CustomResourceDefinition
     */
    Mono<CustomResourceDefinition> update(String name, CustomResourceDefinition body, UpdateOptions options);

    /**
     * replace status of the specified CustomResourceDefinition
     */
    Mono<CustomResourceDefinition> updateStatus(String name, CustomResourceDefinition body, UpdateOptions options);

}
