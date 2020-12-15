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

import io.k8s.autoscaling.v1.Scale;
import io.k8s.meta.v1.GetOptions;
import io.k8s.meta.v1.PatchOptions;
import io.k8s.meta.v1.UpdateOptions;
import io.k8s.type.PatchType;
import reactor.core.publisher.Mono;

public interface ScaleClient {

    /**
     * read scale of the specified ReplicationController
     */
    Mono<Scale> getScale(String name, GetOptions options);

    /**
     * read scale of the specified Deployment
     */
    Mono<Scale> getScale(String name, GetOptions options);

    /**
     * read scale of the specified ReplicaSet
     */
    Mono<Scale> getScale(String name, GetOptions options);

    /**
     * read scale of the specified StatefulSet
     */
    Mono<Scale> getScale(String name, GetOptions options);

    /**
     * partially update scale of the specified ReplicationController
     */
    Mono<Scale> patchScale(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * partially update scale of the specified Deployment
     */
    Mono<Scale> patchScale(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * partially update scale of the specified ReplicaSet
     */
    Mono<Scale> patchScale(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * partially update scale of the specified StatefulSet
     */
    Mono<Scale> patchScale(String name, PatchType type, Object body, PatchOptions options, String... subresources);

    /**
     * replace scale of the specified ReplicationController
     */
    Mono<Scale> updateScale(String name, Scale body, UpdateOptions options);

    /**
     * replace scale of the specified Deployment
     */
    Mono<Scale> updateScale(String name, Scale body, UpdateOptions options);

    /**
     * replace scale of the specified ReplicaSet
     */
    Mono<Scale> updateScale(String name, Scale body, UpdateOptions options);

    /**
     * replace scale of the specified StatefulSet
     */
    Mono<Scale> updateScale(String name, Scale body, UpdateOptions options);

}
