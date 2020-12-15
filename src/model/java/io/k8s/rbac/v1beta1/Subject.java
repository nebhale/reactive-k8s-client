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

package io.k8s.rbac.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Subject contains a reference to the object or user identities a role binding applies to.  This can either hold a
 * direct API object reference, or a value for non-objects such as user and group names.
 */
@Builder
@Jacksonized
@Value
public class Subject {

    /**
     * APIGroup holds the API group of the referenced subject. Defaults to "" for ServiceAccount subjects. Defaults to
     * "rbac.authorization.k8s.io" for User and Group subjects.
     */
    @Nullable
    String apiGroup;

    /**
     * Kind of object being referenced. Values defined by this API group are "User", "Group", and "ServiceAccount". If
     * the Authorizer does not recognized the kind value, the Authorizer should report an error.
     */
    @NonNull
    String kind;

    /**
     * Name of the object being referenced.
     */
    @NonNull
    String name;

    /**
     * Namespace of the referenced object.  If the object kind is non-namespace, such as "User" or "Group", and this
     * value is not empty the Authorizer should report an error.
     */
    @Nullable
    String namespace;

}
