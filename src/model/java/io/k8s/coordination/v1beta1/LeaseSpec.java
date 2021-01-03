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

package io.k8s.coordination.v1beta1;

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * LeaseSpec is a specification of a Lease.
 */
@Builder
@Jacksonized
@Value
public class LeaseSpec {

    @Nullable
    OffsetDateTime acquireTime;

    /**
     * holderIdentity contains the identity of the holder of a current lease.
     */
    @Nullable
    String holderIdentity;

    /**
     * leaseDurationSeconds is a duration that candidates for a lease need to wait to force acquire it. This is measure
     * against time of last observed RenewTime.
     */
    @Nullable
    Integer leaseDurationSeconds;

    /**
     * leaseTransitions is the number of transitions of a lease between holders.
     */
    @Nullable
    Integer leaseTransitions;

    @Nullable
    OffsetDateTime renewTime;

}
