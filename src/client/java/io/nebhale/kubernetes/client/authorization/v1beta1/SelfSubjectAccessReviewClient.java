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

package io.nebhale.kubernetes.client.authorization.v1beta1;

import io.k8s.authorization.v1beta1.SelfSubjectAccessReview;
import io.k8s.meta.v1.CreateOptions;
import reactor.core.publisher.Mono;

public interface SelfSubjectAccessReviewClient {

    /**
     * create a SelfSubjectAccessReview
     */
    Mono<SelfSubjectAccessReview> create(SelfSubjectAccessReview body, CreateOptions options);

}
