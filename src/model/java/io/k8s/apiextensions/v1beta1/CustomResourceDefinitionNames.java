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

package io.k8s.apiextensions.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CustomResourceDefinitionNames indicates the names to serve this CustomResourceDefinition
 */
@Builder
@Jacksonized
@Value
public class CustomResourceDefinitionNames {

    /**
     * categories is a list of grouped resources this custom resource belongs to (e.g. 'all'). This is published in API
     * discovery documents, and used by clients to support invocations like `kubectl get all`.
     */
    @Nullable
    @Singular
    List<String> categories;

    /**
     * kind is the serialized kind of the resource. It is normally CamelCase and singular. Custom resource instances
     * will use this value as the `kind` attribute in API calls.
     */
    @NonNull
    String kind;

    /**
     * listKind is the serialized kind of the list for this resource. Defaults to "`kind`List".
     */
    @Nullable
    String listKind;

    /**
     * plural is the plural name of the resource to serve. The custom resources are served under
     * `/apis/<group>/<version>/.../<plural>`. Must match the name of the CustomResourceDefinition (in the form
     * `<names.plural>.<group>`). Must be all lowercase.
     */
    @NonNull
    String plural;

    /**
     * shortNames are short names for the resource, exposed in API discovery documents, and used by clients to support
     * invocations like `kubectl get <shortname>`. It must be all lowercase.
     */
    @Nullable
    @Singular
    List<String> shortNames;

    /**
     * singular is the singular name of the resource. It must be all lowercase. Defaults to lowercased `kind`.
     */
    @Nullable
    String singular;

}
