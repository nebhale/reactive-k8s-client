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

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ServiceBackendPort is the service port being referenced.
 */
@Builder
@Jacksonized
@Value
public class ServiceBackendPort {

    /**
     * Name is the name of the port on the Service. This is a mutually exclusive setting with "Number".
     */
    @Nullable
    String name;

    /**
     * Number is the numerical port number (e.g. 80) on the Service. This is a mutually exclusive setting with "Name".
     */
    @Nullable
    Integer number;

}
