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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * APIResourceList is a list of APIResource, it is used to expose the name of the resources supported in a specific
 * group and version, and if the resource is namespaced.
 */
@Builder
@Jacksonized
@Value
public class APIResourceList implements TypeMeta {

    public static final String GROUP = "";

    public static final String KIND = "APIResourceList";

    public static final String VERSION = "v1";

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized
     * schemas to the latest internal value, and may reject unrecognized values. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @Nullable
    String apiVersion;

    /**
     * groupVersion is the group and version this APIResourceList is for.
     */
    @NonNull
    String groupVersion;

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the
     * endpoint the client submits requests to. Cannot be updated. In CamelCase. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @Nullable
    String kind;

    /**
     * resources contains the name of the resources and if they are namespaced.
     */
    @NonNull
    @Singular
    List<APIResource> resources;

}
