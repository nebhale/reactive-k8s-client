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

package io.nebhale.kubernetes.client.apiregistration.v1beta1;

import io.k8s.apiregistration.v1beta1.APIService;
import io.k8s.apiregistration.v1beta1.APIServiceList;
import io.k8s.meta.v1.CreateOptions;
import io.k8s.meta.v1.DeleteOptions;
import io.k8s.meta.v1.GetOptions;
import io.k8s.meta.v1.ListOptions;
import io.k8s.meta.v1.PatchOptions;
import io.k8s.meta.v1.Status;
import io.k8s.meta.v1.UpdateOptions;
import io.k8s.type.PatchType;
import reactor.core.publisher.Mono;

public interface APIServiceClient {

    /**
     * create an APIService
     */
    Mono<APIService> create(APIService body, CreateOptions options);

    /**
     * delete an APIService
     */
    Mono<Status> delete(String name, DeleteOptions body);

    /**
     * delete collection of APIService
     */
    Mono<Status> deleteCollection(DeleteOptions body, ListOptions options);

    /**
     * read the specified APIService
     */
    Mono<APIService> get(String name, GetOptions options);

    /**
     * read status of the specified APIService
     */
    Mono<APIService> getStatus(String name, GetOptions options);

    /**
     * list or watch objects of kind APIService
     */
    Mono<APIServiceList> list(ListOptions options);

    /**
     * partially update the specified APIService
     */
    Mono<APIService> patch(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * partially update status of the specified APIService
     */
    Mono<APIService> patchStatus(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * replace the specified APIService
     */
    Mono<APIService> update(APIService body, UpdateOptions options);

    /**
     * replace status of the specified APIService
     */
    Mono<APIService> updateStatus(APIService body, UpdateOptions options);

}
