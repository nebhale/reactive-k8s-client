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

package io.nebhale.kubernetes.client.storage.v1beta1;

import io.k8s.meta.v1.CreateOptions;
import io.k8s.meta.v1.DeleteOptions;
import io.k8s.meta.v1.GetOptions;
import io.k8s.meta.v1.ListOptions;
import io.k8s.meta.v1.PatchOptions;
import io.k8s.meta.v1.Status;
import io.k8s.meta.v1.UpdateOptions;
import io.k8s.storage.v1beta1.StorageClass;
import io.k8s.storage.v1beta1.StorageClassList;
import io.k8s.type.PatchType;
import reactor.core.publisher.Mono;

public interface StorageClassClient {

    /**
     * create a StorageClass
     */
    Mono<StorageClass> create(StorageClass body, CreateOptions options);

    /**
     * delete a StorageClass
     */
    Mono<StorageClass> delete(String name, DeleteOptions body);

    /**
     * delete collection of StorageClass
     */
    Mono<Status> deleteCollection(DeleteOptions body, ListOptions options);

    /**
     * read the specified StorageClass
     */
    Mono<StorageClass> get(String name, GetOptions options);

    /**
     * list or watch objects of kind StorageClass
     */
    Mono<StorageClassList> list(ListOptions options);

    /**
     * partially update the specified StorageClass
     */
    Mono<StorageClass> patch(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * replace the specified StorageClass
     */
    Mono<StorageClass> update(StorageClass body, UpdateOptions options);

}
