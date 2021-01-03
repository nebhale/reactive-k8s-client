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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * WebhookConversion describes how to call a conversion webhook
 */
@Builder
@Jacksonized
@Value
public class WebhookConversion {

    @Nullable
    WebhookClientConfig clientConfig;

    /**
     * conversionReviewVersions is an ordered list of preferred `ConversionReview` versions the Webhook expects. The API
     * server will use the first version in the list which it supports. If none of the versions specified in this list
     * are supported by API server, conversion will fail for the custom resource. If a persisted Webhook configuration
     * specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will
     * fail.
     */
    @NonNull
    @Singular
    List<String> conversionReviewVersions;

}
