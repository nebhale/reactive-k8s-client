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

package io.k8s.core.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * WindowsSecurityContextOptions contain Windows-specific options and credentials.
 */
@Builder
@Jacksonized
@Value
public class WindowsSecurityContextOptions {

    /**
     * GMSACredentialSpec is where the GMSA admission webhook (https://github.com/kubernetes-sigs/windows-gmsa) inlines
     * the contents of the GMSA credential spec named by the GMSACredentialSpecName field.
     */
    @Nullable
    String gmsaCredentialSpec;

    /**
     * GMSACredentialSpecName is the name of the GMSA credential spec to use.
     */
    @Nullable
    String gmsaCredentialSpecName;

    /**
     * The UserName in Windows to run the entrypoint of the container process. Defaults to the user specified in image
     * metadata if unspecified. May also be set in PodSecurityContext. If set in both SecurityContext and
     * PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @Nullable
    String runAsUserName;

}
