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

package io.k8s.networking.v1;

import io.k8s.core.v1.TypedLocalObjectReference;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * IngressClassSpec provides information about the class of an Ingress.
 */
@Builder
@Jacksonized
@Value
public class IngressClassSpec {

    /**
     * Controller refers to the name of the controller that should handle this class. This allows for different
     * "flavors" that are controlled by the same controller. For example, you may have different Parameters for the same
     * implementing controller. This should be specified as a domain-prefixed path no more than 250 characters in
     * length, e.g. "acme.io/ingress-controller". This field is immutable.
     */
    @Nullable
    String controller;

    @Nullable
    TypedLocalObjectReference parameters;

}
