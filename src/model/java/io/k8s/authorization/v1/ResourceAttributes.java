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

package io.k8s.authorization.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ResourceAttributes includes the authorization attributes available for resource requests to the Authorizer interface
 */
@Builder
@Jacksonized
@Value
public class ResourceAttributes {

    /**
     * Group is the API Group of the Resource.  "*" means all.
     */
    @Nullable
    String group;

    /**
     * Name is the name of the resource being requested for a "get" or deleted for a "delete". "" (empty) means all.
     */
    @Nullable
    String name;

    /**
     * Namespace is the namespace of the action being requested.  Currently, there is no distinction between no
     * namespace and all namespaces "" (empty) is defaulted for LocalSubjectAccessReviews "" (empty) is empty for
     * cluster-scoped resources "" (empty) means "all" for namespace scoped resources from a SubjectAccessReview or
     * SelfSubjectAccessReview
     */
    @Nullable
    String namespace;

    /**
     * Resource is one of the existing resource types.  "*" means all.
     */
    @Nullable
    String resource;

    /**
     * Subresource is one of the existing resource types.  "" means none.
     */
    @Nullable
    String subresource;

    /**
     * Verb is a kubernetes resource API verb, like: get, list, watch, create, update, delete, proxy.  "*" means all.
     */
    @Nullable
    String verb;

    /**
     * Version is the API Version of the Resource.  "*" means all.
     */
    @Nullable
    String version;

}
