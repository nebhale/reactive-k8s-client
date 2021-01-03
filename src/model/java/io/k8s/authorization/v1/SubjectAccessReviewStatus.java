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

package io.k8s.authorization.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * SubjectAccessReviewStatus
 */
@Builder
@Jacksonized
@Value
public class SubjectAccessReviewStatus {

    /**
     * Allowed is required. True if the action would be allowed, false otherwise.
     */
    @NonNull
    Boolean allowed;

    /**
     * Denied is optional. True if the action would be denied, otherwise false. If both allowed is false and denied is
     * false, then the authorizer has no opinion on whether to authorize the action. Denied may not be true if Allowed
     * is true.
     */
    @Nullable
    Boolean denied;

    /**
     * EvaluationError is an indication that some error occurred during the authorization check. It is entirely possible
     * to get an error and be able to continue determine authorization status in spite of it. For instance, RBAC can be
     * missing a role, but enough roles are still present and bound to reason about the request.
     */
    @Nullable
    String evaluationError;

    /**
     * Reason is optional.  It indicates why a request was allowed or denied.
     */
    @Nullable
    String reason;

}
