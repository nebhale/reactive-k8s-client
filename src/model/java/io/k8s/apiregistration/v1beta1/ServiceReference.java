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

package io.k8s.apiregistration.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ServiceReference holds a reference to Service.legacy.k8s.io
 */
@Builder
@Jacksonized
@Value
public class ServiceReference {

    /**
     * Name is the name of the service
     */
    @Nullable
    String name;

    /**
     * Namespace is the namespace of the service
     */
    @Nullable
    String namespace;

    /**
     * If specified, the port on the service that hosting webhook. Default to 443 for backward compatibility. `port`
     * should be a valid port number (1-65535, inclusive).
     */
    @Nullable
    Integer port;

}
