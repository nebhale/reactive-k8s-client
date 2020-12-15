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

import io.k8s.core.v1.Pod;
import io.k8s.core.v1.PodList;
import io.k8s.meta.v1.CreateOptions;
import io.k8s.meta.v1.DeleteOptions;
import io.k8s.meta.v1.GetOptions;
import io.k8s.meta.v1.ListOptions;
import io.k8s.meta.v1.PatchOptions;
import io.k8s.meta.v1.Status;
import io.k8s.meta.v1.UpdateOptions;
import io.k8s.type.PatchType;
import reactor.core.publisher.Mono;

public interface PodClient {

    /**
     * create a Pod
     */
    Mono<Pod> create(Pod body, CreateOptions options);

    /**
     * delete a Pod
     */
    Mono<Pod> delete(String name, DeleteOptions body);

    /**
     * delete collection of Pod
     */
    Mono<Status> deleteCollection(DeleteOptions body, ListOptions options);

    /**
     * read the specified Pod
     */
    Mono<Pod> get(String name, GetOptions options);

    /**
     * read log of the specified Pod
     */
    Mono<String> getLog(String container, Boolean follow, Boolean insecureSkipTLSVerifyBackend, Integer limitBytes, String name, Boolean previous, Integer sinceSeconds, Integer tailLines, Boolean timestamps, GetOptions options);

    /**
     * read status of the specified Pod
     */
    Mono<Pod> getStatus(String name, GetOptions options);

    /**
     * list or watch objects of kind Pod
     */
    Mono<PodList> list(ListOptions options);

    /**
     * partially update the specified Pod
     */
    Mono<Pod> patch(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * partially update status of the specified Pod
     */
    Mono<Pod> patchStatus(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * replace the specified Pod
     */
    Mono<Pod> update(String name, Pod body, UpdateOptions options);

    /**
     * replace status of the specified Pod
     */
    Mono<Pod> updateStatus(String name, Pod body, UpdateOptions options);

}
