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

package io.k8s.apps.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * StatefulSetUpdateStrategy indicates the strategy that the StatefulSet controller will use to perform updates. It
 * includes any additional parameters necessary to perform the update for the indicated strategy.
 */
@Builder
@Jacksonized
@Value
public class StatefulSetUpdateStrategy {

    @Nullable
    RollingUpdateStatefulSetStrategy rollingUpdate;

    /**
     * Type indicates the type of the StatefulSetUpdateStrategy. Default is RollingUpdate.
     */
    @Nullable
    String type;

}
