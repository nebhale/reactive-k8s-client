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

package io.k8s.apiextensions.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CustomResourceDefinitionVersion describes a version for CRD.
 */
@Builder
@Jacksonized
@Value
public class CustomResourceDefinitionVersion {

    /**
     * additionalPrinterColumns specifies additional columns returned in Table output. See
     * https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. If no
     * columns are specified, a single column displaying the age of the custom resource is used.
     */
    @Nullable
    @Singular
    List<CustomResourceColumnDefinition> additionalPrinterColumns;

    /**
     * name is the version name, e.g. “v1”, “v2beta1”, etc. The custom resources are served under this version at
     * `/apis/<group>/<version>/...` if `served` is true.
     */
    @NonNull
    String name;

    @Nullable
    CustomResourceValidation schema;

    /**
     * served is a flag enabling/disabling this version from being served via REST APIs
     */
    @NonNull
    Boolean served;

    /**
     * storage indicates this version should be used when persisting custom resources to storage. There must be exactly
     * one version with storage=true.
     */
    @NonNull
    Boolean storage;

    @Nullable
    CustomResourceSubresources subresources;

}
