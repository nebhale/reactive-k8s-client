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

package io.k8s.authentication.v1;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * UserInfo holds the information about the user needed to implement the user.Info interface.
 */
@Builder
@Jacksonized
@Value
public class UserInfo {

    /**
     * Any additional information provided by the authenticator.
     */
    @Nullable
    @Singular("extra")
    Map<String, List<String>> extra;

    /**
     * The names of groups this user is a part of.
     */
    @Nullable
    @Singular
    List<String> groups;

    /**
     * A unique value that identifies this user across time. If this user is deleted and another user by the same name
     * is added, they will have different UIDs.
     */
    @Nullable
    String uid;

    /**
     * The name that uniquely identifies this user among all active users.
     */
    @Nullable
    String username;

}
