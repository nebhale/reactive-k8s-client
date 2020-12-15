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

package io.k8s.authorization.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * ResourceRule is the list of actions the subject is allowed to perform on resources. The list ordering isn't
 * significant, may contain duplicates, and possibly be incomplete.
 */
@Builder
@Jacksonized
@Value
public class ResourceRule {

    /**
     * APIGroups is the name of the APIGroup that contains the resources.  If multiple API groups are specified, any
     * action requested against one of the enumerated resources in any API group will be allowed.  "*" means all.
     */
    @Nullable
    @Singular
    List<String> apiGroups;

    /**
     * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is
     * allowed.  "*" means all.
     */
    @Nullable
    @Singular
    List<String> resourceNames;

    /**
     * Resources is a list of resources this rule applies to.  "*" means all in the specified apiGroups.
     * 
     * "&#42;&#47;foo" represents the subresource 'foo' for all resources in the specified apiGroups.
     */
    @Nullable
    @Singular
    List<String> resources;

    /**
     * Verb is a list of kubernetes resource API verbs, like: get, list, watch, create, update, delete, proxy.  "*"
     * means all.
     */
    @NonNull
    @Singular
    List<String> verbs;

}
