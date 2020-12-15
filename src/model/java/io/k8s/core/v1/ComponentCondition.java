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
 * Information about the condition of a component.
 */
@Builder
@Jacksonized
@Value
public class ComponentCondition {

    /**
     * Condition error code for a component. For example, a health check error code.
     */
    @Nullable
    String error;

    /**
     * Message about the condition for a component. For example, information about a health check.
     */
    @Nullable
    String message;

    /**
     * Status of the condition for a component. Valid values for "Healthy": "True", "False", or "Unknown".
     */
    @NonNull
    String status;

    /**
     * Type of condition for a component. Valid value: "Healthy"
     */
    @NonNull
    String type;

}
