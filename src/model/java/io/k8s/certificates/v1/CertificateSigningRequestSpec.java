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
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CertificateSigningRequestSpec contains the certificate request.
 */
@Builder
@Jacksonized
@Value
public class CertificateSigningRequestSpec {

    /**
     * extra contains extra attributes of the user that created the CertificateSigningRequest. Populated by the API
     * server on creation and immutable.
     */
    @Nullable
    @Singular("extra")
    Map<String, List<String>> extra;

    /**
     * groups contains group membership of the user that created the CertificateSigningRequest. Populated by the API
     * server on creation and immutable.
     */
    @Nullable
    @Singular
    List<String> groups;

    /**
     * request contains an x509 certificate signing request encoded in a "CERTIFICATE REQUEST" PEM block. When
     * serialized as JSON or YAML, the data is additionally base64-encoded.
     */
    @NonNull
    String request;

    /**
     * signerName indicates the requested signer, and is a qualified name.
     * 
     * List/watch requests for
     * CertificateSigningRequests can filter on this field using a "spec.signerName=NAME" fieldSelector.
     * 
     * Well-known
     * Kubernetes signers are:
     *  1. "kubernetes.io/kube-apiserver-client": issues client certificates that can be used to
     * authenticate to kube-apiserver.
     *   Requests for this signer are never auto-approved by kube-controller-manager,
     * can be issued by the "csrsigning" controller in kube-controller-manager.
     *  2.
     * "kubernetes.io/kube-apiserver-client-kubelet": issues client certificates that kubelets use to authenticate to
     * kube-apiserver.
     *   Requests for this signer can be auto-approved by the "csrapproving" controller in
     * kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.
     *  3.
     * "kubernetes.io/kubelet-serving" issues serving certificates that kubelets use to serve TLS endpoints, which
     * kube-apiserver can connect to securely.
     *   Requests for this signer are never auto-approved by
     * kube-controller-manager, and can be issued by the "csrsigning" controller in kube-controller-manager.
     * 
     * More
     * details are available at
     * https://k8s.io/docs/reference/access-authn-authz/certificate-signing-requests/#kubernetes-signers
     * 
     * Custom
     * signerNames can also be specified. The signer defines:
     *  1. Trust distribution: how trust (CA bundles) are
     * distributed.
     *  2. Permitted subjects: and behavior when a disallowed subject is requested.
     *  3. Required,
     * permitted, or forbidden x509 extensions in the request (including whether subjectAltNames are allowed, which
     * types, restrictions on allowed values) and behavior when a disallowed extension is requested.
     *  4. Required,
     * permitted, or forbidden key usages / extended key usages.
     *  5. Expiration/certificate lifetime: whether it is
     * fixed by the signer, configurable by the admin.
     *  6. Whether or not requests for CA certificates are allowed.
     */
    @NonNull
    String signerName;

    /**
     * uid contains the uid of the user that created the CertificateSigningRequest. Populated by the API server on
     * creation and immutable.
     */
    @Nullable
    String uid;

    /**
     * usages specifies a set of key usages requested in the issued certificate.
     * 
     * Requests for TLS client certificates
     * typically request: "digital signature", "key encipherment", "client auth".
     * 
     * Requests for TLS serving certificates
     * typically request: "key encipherment", "digital signature", "server auth".
     * 
     * Valid values are:
     *  "signing",
     * "digital signature", "content commitment",
     *  "key encipherment", "key agreement", "data encipherment",
     *  "cert
     * sign", "crl sign", "encipher only", "decipher only", "any",
     *  "server auth", "client auth",
     *  "code signing",
     * "email protection", "s/mime",
     *  "ipsec end system", "ipsec tunnel", "ipsec user",
     *  "timestamping", "ocsp signing",
     * "microsoft sgc", "netscape sgc"
     */
    @Nullable
    @Singular
    List<String> usages;

    /**
     * username contains the name of the user that created the CertificateSigningRequest. Populated by the API server on
     * creation and immutable.
     */
    @Nullable
    String username;

}
