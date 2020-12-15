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
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * SubjectAccessReviewSpec is a description of the access request.  Exactly one of ResourceAuthorizationAttributes and
 * NonResourceAuthorizationAttributes must be set
 */
@Builder
@Jacksonized
@Value
public class SubjectAccessReviewSpec {

    /**
     * Extra corresponds to the user.Info.GetExtra() method from the authenticator.  Since that is input to the
     * authorizer it needs a reflection here.
     */
    @Nullable
    @Singular("extra")
    Map<String, List<String>> extra;

    /**
     * Groups is the groups you're testing for.
     */
    @Nullable
    @Singular("group")
    List<String> group;

    @Nullable
    NonResourceAttributes nonResourceAttributes;

    @Nullable
    ResourceAttributes resourceAttributes;

    /**
     * UID information about the requesting user.
     */
    @Nullable
    String uid;

    /**
     * User is the user you're testing for. If you specify "User" but not "Group", then is it interpreted as "What if
     * User were not a member of any groups
     */
    @Nullable
    String user;

}
