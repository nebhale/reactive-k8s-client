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
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

@Builder
@Jacksonized
@Value
public class CertificateSigningRequestStatus {

    /**
     * If request was approved, the controller will place the issued certificate here.
     */
    @Nullable
    String certificate;

    /**
     * Conditions applied to the request, such as approval or denial.
     */
    @Nullable
    @Singular
    List<CertificateSigningRequestCondition> conditions;

}
