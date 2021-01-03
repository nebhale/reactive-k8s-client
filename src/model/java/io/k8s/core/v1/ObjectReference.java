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

import io.k8s.meta.v1.TypeMeta;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ObjectReference contains enough information to let you inspect or modify the referred object.
 */
@Builder
@Jacksonized
@Value
public class ObjectReference implements TypeMeta {

    /**
     * API version of the referent.
     */
    @Nullable
    String apiVersion;

    /**
     * If referring to a piece of an object instead of an entire object, this string should contain a valid JSON/Go
     * field access statement, such as desiredState.manifest.containers[2]. For example, if the object reference is to a
     * container within a pod, this would take on a value like: "spec.containers{name}" (where "name" refers to the name
     * of the container that triggered the event) or if no container name is specified "spec.containers[2]" (container
     * with index 2 in this pod). This syntax is chosen only to have some well-defined way of referencing a part of an
     * object.
     */
    @Nullable
    String fieldPath;

    /**
     * Kind of the referent. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @Nullable
    String kind;

    /**
     * Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     */
    @Nullable
    String name;

    /**
     * Namespace of the referent. More info:
     * https://kubernetes.io/docs/concepts/overview/working-with-objects/namespaces/
     */
    @Nullable
    String namespace;

    /**
     * Specific resourceVersion to which this reference is made, if any. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#concurrency-control-and-consistency
     */
    @Nullable
    String resourceVersion;

    /**
     * UID of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#uids
     */
    @Nullable
    String uid;

}
