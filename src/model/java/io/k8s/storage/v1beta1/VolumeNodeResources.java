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

package io.k8s.storage.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * VolumeNodeResources is a set of resource limits for scheduling of volumes.
 */
@Builder
@Jacksonized
@Value
public class VolumeNodeResources {

    /**
     * Maximum number of unique volumes managed by the CSI driver that can be used on a node. A volume that is both
     * attached and mounted on a node is considered to be used once, not twice. The same rule applies for a unique
     * volume that is shared among multiple pods on the same node. If this field is nil, then the supported number of
     * volumes on this node is unbounded.
     */
    @Nullable
    Integer count;

}
