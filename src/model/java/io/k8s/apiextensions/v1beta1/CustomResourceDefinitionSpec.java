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

package io.k8s.apiextensions.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CustomResourceDefinitionSpec describes how a user wants their resource to appear
 */
@Builder
@Jacksonized
@Value
public class CustomResourceDefinitionSpec {

    /**
     * additionalPrinterColumns specifies additional columns returned in Table output. See
     * https://kubernetes.io/docs/reference/using-api/api-concepts/#receiving-resources-as-tables for details. If
     * present, this field configures columns for all versions. Top-level and per-version columns are mutually
     * exclusive. If no top-level or per-version columns are specified, a single column displaying the age of the custom
     * resource is used.
     */
    @Nullable
    @Singular
    List<CustomResourceColumnDefinition> additionalPrinterColumns;

    @Nullable
    CustomResourceConversion conversion;

    /**
     * group is the API group of the defined custom resource. The custom resources are served under `/apis/<group>/...`.
     * Must match the name of the CustomResourceDefinition (in the form `<names.plural>.<group>`).
     */
    @NonNull
    String group;

    @NonNull
    CustomResourceDefinitionNames names;

    /**
     * scope indicates whether the defined custom resource is cluster- or namespace-scoped. Allowed values are `Cluster`
     * and `Namespaced`. Default is `Namespaced`.
     */
    @NonNull
    String scope;

    @Nullable
    CustomResourceSubresources subresources;

    @Nullable
    CustomResourceValidation validation;

    /**
     * versions is the list of all API versions of the defined custom resource. Optional if `version` is specified. The
     * name of the first item in the `versions` list must match the `version` field if `version` and `versions` are both
     * specified. Version names are used to compute the order in which served versions are listed in API discovery. If
     * the version string is "kube-like", it will sort above non "kube-like" version strings, which are ordered
     * lexicographically. "Kube-like" versions start with a "v", then are followed by a number (the major version), then
     * optionally the string "alpha" or "beta" and another number (the minor version). These are sorted first by GA >
     * beta > alpha (where GA is a version with no suffix such as beta or alpha), and then by comparing major version,
     * then minor version. An example sorted list of versions: v10, v2, v1, v11beta2, v10beta3, v3beta1, v12alpha1,
     * v11alpha2, foo1, foo10.
     */
    @Nullable
    @Singular
    List<CustomResourceDefinitionVersion> versions;

}
