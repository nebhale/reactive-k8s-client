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

package io.k8s.policy.v1beta1;

import io.k8s.core.v1.SELinuxOptions;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * SELinuxStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@Builder
@Jacksonized
@Value
public class SELinuxStrategyOptions {

    /**
     * rule is the strategy that will dictate the allowable labels that may be set.
     */
    @NonNull
    String rule;

    @Nullable
    SELinuxOptions seLinuxOptions;

}
