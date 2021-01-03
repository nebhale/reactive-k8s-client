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

package io.k8s.core.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * SecretReference represents a Secret Reference. It has enough information to retrieve secret in any namespace
 */
@Builder
@Jacksonized
@Value
public class SecretReference {

    /**
     * Name is unique within a namespace to reference a secret resource.
     */
    @Nullable
    String name;

    /**
     * Namespace defines the space within which the secret name must be unique.
     */
    @Nullable
    String namespace;

}
