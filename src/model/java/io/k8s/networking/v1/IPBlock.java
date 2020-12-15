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

package io.k8s.networking.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * IPBlock describes a particular CIDR (Ex. "192.168.1.1/24","2001:db9::/64") that is allowed to the pods matched by a
 * NetworkPolicySpec's podSelector. The except entry describes CIDRs that should not be included within this rule.
 */
@Builder
@Jacksonized
@Value
public class IPBlock {

    /**
     * CIDR is a string representing the IP Block Valid examples are "192.168.1.1/24" or "2001:db9::/64"
     */
    @NonNull
    String cidr;

    /**
     * Except is a slice of CIDRs that should not be included within an IP Block Valid examples are "192.168.1.1/24" or
     * "2001:db9::/64" Except values will be rejected if they are outside the CIDR range
     */
    @Nullable
    @Singular("except")
    List<String> except;

}
