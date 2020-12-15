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

package io.k8s.authorization.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * SubjectRulesReviewStatus contains the result of a rules check. This check can be incomplete depending on the set of
 * authorizers the server is configured with and any errors experienced during evaluation. Because authorization rules
 * are additive, if a rule appears in a list it's safe to assume the subject has that permission, even if that list is
 * incomplete.
 */
@Builder
@Jacksonized
@Value
public class SubjectRulesReviewStatus {

    /**
     * EvaluationError can appear in combination with Rules. It indicates an error occurred during rule evaluation, such
     * as an authorizer that doesn't support rule evaluation, and that ResourceRules and/or NonResourceRules may be
     * incomplete.
     */
    @Nullable
    String evaluationError;

    /**
     * Incomplete is true when the rules returned by this call are incomplete. This is most commonly encountered when an
     * authorizer, such as an external authorizer, doesn't support rules evaluation.
     */
    @NonNull
    Boolean incomplete;

    /**
     * NonResourceRules is the list of actions the subject is allowed to perform on non-resources. The list ordering
     * isn't significant, may contain duplicates, and possibly be incomplete.
     */
    @NonNull
    @Singular
    List<NonResourceRule> nonResourceRules;

    /**
     * ResourceRules is the list of actions the subject is allowed to perform on resources. The list ordering isn't
     * significant, may contain duplicates, and possibly be incomplete.
     */
    @NonNull
    @Singular
    List<ResourceRule> resourceRules;

}
