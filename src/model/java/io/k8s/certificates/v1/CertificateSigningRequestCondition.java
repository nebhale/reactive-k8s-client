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

package io.k8s.certificates.v1;

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CertificateSigningRequestCondition describes a condition of a CertificateSigningRequest object
 */
@Builder
@Jacksonized
@Value
public class CertificateSigningRequestCondition {

    @Nullable
    OffsetDateTime lastTransitionTime;

    @Nullable
    OffsetDateTime lastUpdateTime;

    /**
     * message contains a human readable message with details about the request state
     */
    @Nullable
    String message;

    /**
     * reason indicates a brief reason for the request state
     */
    @Nullable
    String reason;

    /**
     * status of the condition, one of True, False, Unknown. Approved, Denied, and Failed conditions may not be "False"
     * or "Unknown".
     */
    @NonNull
    String status;

    /**
     * type of the condition. Known conditions are "Approved", "Denied", and "Failed".
     * 
     * An "Approved" condition is added
     * via the /approval subresource, indicating the request was approved and should be issued by the signer.
     * 
     * A
     * "Denied" condition is added via the /approval subresource, indicating the request was denied and should not be
     * issued by the signer.
     * 
     * A "Failed" condition is added via the /status subresource, indicating the signer failed to
     * issue the certificate.
     * 
     * Approved and Denied conditions are mutually exclusive. Approved, Denied, and Failed
     * conditions cannot be removed once added.
     * 
     * Only one condition of a given type is allowed.
     */
    @NonNull
    String type;

}
