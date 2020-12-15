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

package io.k8s.apiextensions.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * CustomResourceSubresourceStatus defines how to serve the status subresource for CustomResources. Status is
 * represented by the `.status` JSON path inside of a CustomResource. When set, * exposes a /status subresource for the
 * custom resource * PUT requests to the /status subresource take a custom resource object, and ignore changes to
 * anything except the status stanza * PUT/POST/PATCH requests to the custom resource ignore changes to the status
 * stanza
 */
@Builder
@Jacksonized
@Value
public class CustomResourceSubresourceStatus {

}
