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

package io.k8s.core.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * TypedLocalObjectReference contains enough information to let you locate the typed referenced object inside the same
 * namespace.
 */
@Builder
@Jacksonized
@Value
public class TypedLocalObjectReference {

    /**
     * APIGroup is the group for the resource being referenced. If APIGroup is not specified, the specified Kind must be
     * in the core API group. For any other third-party types, APIGroup is required.
     */
    @Nullable
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
