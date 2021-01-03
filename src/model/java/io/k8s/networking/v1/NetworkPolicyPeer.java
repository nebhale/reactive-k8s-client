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

package io.k8s.networking.v1;

import io.k8s.meta.v1.LabelSelector;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * NetworkPolicyPeer describes a peer to allow traffic to/from. Only certain combinations of fields are allowed
 */
@Builder
@Jacksonized
@Value
public class NetworkPolicyPeer {

    @Nullable
    IPBlock ipBlock;

    @Nullable
    LabelSelector namespaceSelector;

    @Nullable
    LabelSelector podSelector;

}
