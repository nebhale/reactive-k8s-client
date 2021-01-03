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

package io.k8s.certificates.v1beta1;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * This information is immutable after the request is created. Only the Request and Usages fields can be set on
 * creation, other fields are derived by Kubernetes and cannot be modified by users.
 */
@Builder
@Jacksonized
@Value
public class CertificateSigningRequestSpec {

    /**
     * Extra information about the requesting user. See user.Info interface for details.
     */
    @Nullable
    @Singular("extra")
    Map<String, List<String>> extra;

    /**
     * Group information about the requesting user. See user.Info interface for details.
     */
    @Nullable
    @Singular
    List<String> groups;

    /**
     * Base64-encoded PKCS#10 CSR data
     */
    @NonNull
    String request;

    /**
     * Requested signer for the request. It is a qualified name in the form: `scope-hostname.io/name`. If empty, it will
     * be defaulted:
     *  1. If it's a kubelet client certificate, it is assigned
     *    
     * "kubernetes.io/kube-apiserver-client-kubelet".
     *  2. If it's a kubelet serving certificate, it is assigned
     *    
     * "kubernetes.io/kubelet-serving".
     *  3. Otherwise, it is assigned "kubernetes.io/legacy-unknown".
     * Distribution of
     * trust for signers happens out of band. You can select on this field using `spec.signerName`.
     */
    @Nullable
    String signerName;

    /**
     * UID information about the requesting user. See user.Info interface for details.
     */
    @Nullable
    String uid;

    /**
     * allowedUsages specifies a set of usage contexts the key will be valid for. See:
     * https://tools.ietf.org/html/rfc5280#section-4.2.1.3
     *     
     * https://tools.ietf.org/html/rfc5280#section-4.2.1.12
     * Valid values are:
     *  "signing",
     *  "digital signature",
     * 
     * "content commitment",
     *  "key encipherment",
     *  "key agreement",
     *  "data encipherment",
     *  "cert sign",
     *  "crl sign",
     * 
     * "encipher only",
     *  "decipher only",
     *  "any",
     *  "server auth",
     *  "client auth",
     *  "code signing",
     *  "email protection",
     * 
     * "s/mime",
     *  "ipsec end system",
     *  "ipsec tunnel",
     *  "ipsec user",
     *  "timestamping",
     *  "ocsp signing",
     *  "microsoft
     * sgc",
     *  "netscape sgc"
     */
    @Nullable
    @Singular
    List<String> usages;

    /**
     * Information about the requesting user. See user.Info interface for details.
     */
    @Nullable
    String username;

}
