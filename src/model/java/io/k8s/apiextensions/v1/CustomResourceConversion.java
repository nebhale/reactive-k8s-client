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

package io.k8s.apiextensions.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CustomResourceConversion describes how to convert different versions of a CR.
 */
@Builder
@Jacksonized
@Value
public class CustomResourceConversion {

    /**
     * strategy specifies how custom resources are converted between versions. Allowed values are: - `None`: The
     * converter only change the apiVersion and would not touch any other field in the custom resource. - `Webhook`: API
     * Server will call to an external webhook to do the conversion. Additional information
     *   is needed for this option.
     * This requires spec.preserveUnknownFields to be false, and spec.conversion.webhook to be set.
     */
    @NonNull
    String strategy;

    @Nullable
    WebhookConversion webhook;

}
