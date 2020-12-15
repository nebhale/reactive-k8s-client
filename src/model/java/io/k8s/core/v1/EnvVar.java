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
 * EnvVar represents an environment variable present in a Container.
 */
@Builder
@Jacksonized
@Value
public class EnvVar {

    /**
     * Name of the environment variable. Must be a C_IDENTIFIER.
     */
    @NonNull
    String name;

    /**
     * Variable references $(VAR_NAME) are expanded using the previous defined environment variables in the container
     * and any service environment variables. If a variable cannot be resolved, the reference in the input string will
     * be unchanged. The $(VAR_NAME) syntax can be escaped with a double $$, ie: $$(VAR_NAME). Escaped references will
     * never be expanded, regardless of whether the variable exists or not. Defaults to "".
     */
    @Nullable
    String value;

    @Nullable
    EnvVarSource valueFrom;

}
