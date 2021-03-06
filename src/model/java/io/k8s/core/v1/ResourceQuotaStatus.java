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

package io.k8s.core.v1;

import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ResourceQuotaStatus defines the enforced hard limits and observed use.
 */
@Builder
@Jacksonized
@Value
public class ResourceQuotaStatus {

    /**
     * Hard is the set of enforced hard limits for each named resource. More info:
     * https://kubernetes.io/docs/concepts/policy/resource-quotas/
     */
    @Nullable
    @Singular("hard")
    Map<String, String> hard;

    /**
     * Used is the current observed total usage of the resource in the namespace.
     */
    @Nullable
    @Singular("used")
    Map<String, String> used;

}
