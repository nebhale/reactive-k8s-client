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

package io.k8s.admissionregistration.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * RuleWithOperations is a tuple of Operations and Resources. It is recommended to make sure that all the tuple
 * expansions are valid.
 */
@Builder
@Jacksonized
@Value
public class RuleWithOperations {

    /**
     * APIGroups is the API groups the resources belong to. '*' is all groups. If '*' is present, the length of the
     * slice must be one. Required.
     */
    @Nullable
    @Singular
    List<String> apiGroups;

    /**
     * APIVersions is the API versions the resources belong to. '*' is all versions. If '*' is present, the length of
     * the slice must be one. Required.
     */
    @Nullable
    @Singular
    List<String> apiVersions;

    /**
     * Operations is the operations the admission hook cares about - CREATE, UPDATE, DELETE, CONNECT or * for all of
     * those operations and any future admission operations that are added. If '*' is present, the length of the slice
     * must be one. Required.
     */
    @Nullable
    @Singular
    List<String> operations;

    /**
     * Resources is a list of resources this rule applies to.
     * 
     * For example: 'pods' means pods. 'pods/log' means the log
     * subresource of pods. '*' means all resources, but not subresources. 'pods/*' means all subresources of pods.
     * '&#42;&#47;scale' means all scale subresources. '&#42;&#47;*' means all resources and their subresources.
     * 
     * If
     * wildcard is present, the validation rule will ensure resources do not overlap with each other.
     * 
     * Depending on the
     * enclosing object, subresources might not be allowed. Required.
     */
    @Nullable
    @Singular
    List<String> resources;

    /**
     * scope specifies the scope of this rule. Valid values are "Cluster", "Namespaced", and "*" "Cluster" means that
     * only cluster-scoped resources will match this rule. Namespace API objects are cluster-scoped. "Namespaced" means
     * that only namespaced resources will match this rule. "*" means that there are no scope restrictions. Subresources
     * match the scope of their parent resource. Default is "*".
     */
    @Nullable
    String scope;

}
