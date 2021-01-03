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

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * GetOptions is the standard query options to the standard REST get call.
 */
@Builder
@Jacksonized
@Value
public class GetOptions implements TypeMeta {

    @Nullable
    String kind;

    @Nullable
    String apiVersion;

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See
     * https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details. Defaults to unset
     */
    String resourceVersion;

}
