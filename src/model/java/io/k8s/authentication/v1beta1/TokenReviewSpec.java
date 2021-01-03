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

package io.k8s.authentication.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * TokenReviewSpec is a description of the token authentication request.
 */
@Builder
@Jacksonized
@Value
public class TokenReviewSpec {

    /**
     * Audiences is a list of the identifiers that the resource server presented with the token identifies as.
     * Audience-aware token authenticators will verify that the token was intended for at least one of the audiences in
     * this list. If no audiences are provided, the audience will default to the audience of the Kubernetes apiserver.
     */
    @Nullable
    @Singular
    List<String> audiences;

    /**
     * Token is the opaque bearer token.
     */
    @Nullable
    String token;

}
