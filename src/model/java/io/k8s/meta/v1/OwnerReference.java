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

package io.k8s.meta.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * OwnerReference contains enough information to let you identify an owning object. An owning object must be in the same
 * namespace as the dependent, or be cluster-scoped, so there is no namespace field.
 */
@Builder
@Jacksonized
@Value
public class OwnerReference implements TypeMeta {

    /**
     * API version of the referent.
     */
    @NonNull
    String apiVersion;

    /**
     * If true, AND if the owner has the "foregroundDeletion" finalizer, then the owner cannot be deleted from the
     * key-value store until this reference is removed. Defaults to false. To set this field, a user needs "delete"
     * permission of the owner, otherwise 422 (Unprocessable Entity) will be returned.
     */
    @Nullable
    Boolean blockOwnerDeletion;

    /**
     * If true, this reference points to the managing controller.
     */
    @Nullable
    Boolean controller;

    /**
     * Kind of the referent. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @NonNull
    String kind;

    /**
     * Name of the referent. More info: http://kubernetes.io/docs/user-guide/identifiers#names
     */
    @NonNull
    String name;

    /**
     * UID of the referent. More info: http://kubernetes.io/docs/user-guide/identifiers#uids
     */
    @NonNull
    String uid;

}
