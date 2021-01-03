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

package io.k8s.discovery.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * EndpointConditions represents the current condition of an endpoint.
 */
@Builder
@Jacksonized
@Value
public class EndpointConditions {

    /**
     * ready indicates that this endpoint is prepared to receive traffic, according to whatever system is managing the
     * endpoint. A nil value indicates an unknown state. In most cases consumers should interpret this unknown state as
     * ready.
     */
    @Nullable
    Boolean ready;

}
