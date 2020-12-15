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

package io.k8s.certificates.v1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * CertificateSigningRequestStatus contains conditions used to indicate approved/denied/failed status of the request,
 * and the issued certificate.
 */
@Builder
@Jacksonized
@Value
public class CertificateSigningRequestStatus {

    /**
     * certificate is populated with an issued certificate by the signer after an Approved condition is present. This
     * field is set via the /status subresource. Once populated, this field is immutable.
     * 
     * If the certificate signing
     * request is denied, a condition of type "Denied" is added and this field remains empty. If the signer cannot issue
     * the certificate, a condition of type "Failed" is added and this field remains empty.
     * 
     * Validation requirements:
     * 
     * 1. certificate must contain one or more PEM blocks.
     *  2. All PEM blocks must have the "CERTIFICATE" label, contain
     * no headers, and the encoded data
     *   must be a BER-encoded ASN.1 Certificate structure as described in section 4 of
     * RFC5280.
     *  3. Non-PEM content may appear before or after the "CERTIFICATE" PEM blocks and is unvalidated,
     *   to
     * allow for explanatory text as described in section 5.2 of RFC7468.
     * 
     * If more than one PEM block is present, and
     * the definition of the requested spec.signerName does not indicate otherwise, the first block is the issued
     * certificate, and subsequent blocks should be treated as intermediate certificates and presented in TLS
     * handshakes.
     * 
     * The certificate is encoded in PEM format.
     * 
     * When serialized as JSON or YAML, the data is additionally
     * base64-encoded, so it consists of:
     * 
     *     base64(
     *     -----BEGIN CERTIFICATE-----
     *     ...
     *     -----END
     * CERTIFICATE-----
     *     )
     */
    @Nullable
    String certificate;

    /**
     * conditions applied to the request. Known conditions are "Approved", "Denied", and "Failed".
     */
    @Nullable
    @Singular
    List<CertificateSigningRequestCondition> conditions;

}
