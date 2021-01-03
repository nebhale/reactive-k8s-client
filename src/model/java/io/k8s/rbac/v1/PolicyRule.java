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

package io.k8s.rbac.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * PolicyRule holds information that describes a policy rule, but does not contain information about who the rule
 * applies to or which namespace the rule applies to.
 */
@Builder
@Jacksonized
@Value
public class PolicyRule {

    /**
     * APIGroups is the name of the APIGroup that contains the resources.  If multiple API groups are specified, any
     * action requested against one of the enumerated resources in any API group will be allowed.
     */
    @Nullable
    @Singular
    List<String> apiGroups;

    /**
     * NonResourceURLs is a set of partial urls that a user should have access to.  *s are allowed, but only as the
     * full, final step in the path Since non-resource URLs are not namespaced, this field is only applicable for
     * ClusterRoles referenced from a ClusterRoleBinding. Rules can either apply to API resources (such as "pods" or
     * "secrets") or non-resource URL paths (such as "/api"),  but not both.
     */
    @Nullable
    @Singular
    List<String> nonResourceURLs;

    /**
     * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is
     * allowed.
     */
    @Nullable
    @Singular
    List<String> resourceNames;

    /**
     * Resources is a list of resources this rule applies to.  ResourceAll represents all resources.
     */
    @Nullable
    @Singular
    List<String> resources;

    /**
     * Verbs is a list of Verbs that apply to ALL the ResourceKinds and AttributeRestrictions contained in this rule. 
     * VerbAll represents all kinds.
     */
    @NonNull
    @Singular
    List<String> verbs;

}
