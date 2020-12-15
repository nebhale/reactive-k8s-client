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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * RuntimeClassStrategyOptions define the strategy that will dictate the allowable RuntimeClasses for a pod.
 */
@Builder
@Jacksonized
@Value
public class RuntimeClassStrategyOptions {

    /**
     * allowedRuntimeClassNames is an allowlist of RuntimeClass names that may be specified on a pod. A value of "*"
     * means that any RuntimeClass name is allowed, and must be the only item in the list. An empty list requires the
     * RuntimeClassName field to be unset.
     */
    @NonNull
    @Singular
    List<String> allowedRuntimeClassNames;

    /**
     * defaultRuntimeClassName is the default RuntimeClassName to set on the pod. The default MUST be allowed by the
     * allowedRuntimeClassNames list. A value of nil does not mutate the Pod.
     */
    @Nullable
    String defaultRuntimeClassName;

}
