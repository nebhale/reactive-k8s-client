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
 * StatusCause provides more information about an api.Status failure, including cases when multiple errors are
 * encountered.
 */
@Builder
@Jacksonized
@Value
public class StatusCause {

    /**
     * The field of the resource that has caused this error, as named by its JSON serialization. May include dot and
     * postfix notation for nested attributes. Arrays are zero-indexed.  Fields may appear more than once in an array of
     * causes due to fields having multiple errors. Optional.
     * 
     * Examples:
     *   "name" - the field "name" on the current
     * resource
     *   "items[0].name" - the field "name" on the first array entry in "items"
     */
    @Nullable
    String field;

    /**
     * A human-readable description of the cause of the error.  This field may be presented as-is to a reader.
     */
    @Nullable
    String message;

    /**
     * A machine-readable description of the cause of the error. If this value is empty there is no information
     * available.
     */
    @Nullable
    String reason;

}
