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

package io.k8s.rbac.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

/**
 * RoleRef contains information that points to the role being used
 */
@Builder
@Jacksonized
@Value
public class RoleRef {

    /**
     * APIGroup is the group for the resource being referenced
     */
    @NonNull
    String apiGroup;

    /**
     * Kind is the type of resource being referenced
     */
    @NonNull
    String kind;

    /**
     * Name is the name of resource being referenced
     */
    @NonNull
    String name;

}
