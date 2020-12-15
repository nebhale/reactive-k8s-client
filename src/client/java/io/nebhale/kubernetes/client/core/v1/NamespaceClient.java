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

package io.nebhale.kubernetes.client.core.v1;

import io.k8s.core.v1.Namespace;
import io.k8s.core.v1.NamespaceList;
import io.k8s.meta.v1.CreateOptions;
import io.k8s.meta.v1.DeleteOptions;
import io.k8s.meta.v1.GetOptions;
import io.k8s.meta.v1.ListOptions;
import io.k8s.meta.v1.PatchOptions;
import io.k8s.meta.v1.Status;
import io.k8s.meta.v1.UpdateOptions;
import io.k8s.type.PatchType;
import reactor.core.publisher.Mono;

public interface NamespaceClient {

    /**
     * create a Namespace
     */
    Mono<Namespace> create(Namespace body, CreateOptions options);

    /**
     * delete a Namespace
     */
    Mono<Status> delete(String name, DeleteOptions body);

    /**
     * read the specified Namespace
     */
    Mono<Namespace> get(String name, GetOptions options);

    /**
     * read status of the specified Namespace
     */
    Mono<Namespace> get(String name, GetOptions options);

    /**
     * list or watch objects of kind Namespace
     */
    Mono<NamespaceList> list(ListOptions options);

    /**
     * partially update the specified Namespace
     */
    Mono<Namespace> patch(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * partially update status of the specified Namespace
     */
    Mono<Namespace> patch(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * replace the specified Namespace
     */
    Mono<Namespace> update(String name, Namespace body, UpdateOptions options);

    /**
     * replace finalize of the specified Namespace
     */
    Mono<Namespace> update(String name, Namespace body, UpdateOptions options);

    /**
     * replace status of the specified Namespace
     */
    Mono<Namespace> update(String name, Namespace body, UpdateOptions options);

}
