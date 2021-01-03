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

package io.k8s.policy.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * RunAsUserStrategyOptions defines the strategy type and any options used to create the strategy.
 */
@Builder
@Jacksonized
@Value
public class RunAsUserStrategyOptions {

    /**
     * ranges are the allowed ranges of uids that may be used. If you would like to force a single uid then supply a
     * single range with the same start and end. Required for MustRunAs.
     */
    @Nullable
    @Singular
    List<IDRange> ranges;

    /**
     * rule is the strategy that will dictate the allowable RunAsUser values that may be set.
     */
    @NonNull
    String rule;

}
