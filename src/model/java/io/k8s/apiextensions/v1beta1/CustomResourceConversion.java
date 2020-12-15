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

package io.k8s.apiextensions.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
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
     * conversionReviewVersions is an ordered list of preferred `ConversionReview` versions the Webhook expects. The API
     * server will use the first version in the list which it supports. If none of the versions specified in this list
     * are supported by API server, conversion will fail for the custom resource. If a persisted Webhook configuration
     * specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will
     * fail. Defaults to `["v1beta1"]`.
     */
    @Nullable
    @Singular
    List<String> conversionReviewVersions;

    /**
     * strategy specifies how custom resources are converted between versions. Allowed values are: - `None`: The
     * converter only change the apiVersion and would not touch any other field in the custom resource. - `Webhook`: API
     * Server will call to an external webhook to do the conversion. Additional information
     *   is needed for this option.
     * This requires spec.preserveUnknownFields to be false, and spec.conversion.webhookClientConfig to be set.
     */
    @NonNull
    String strategy;

    @Nullable
    WebhookClientConfig webhookClientConfig;

}
