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
 * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both
 * SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
 */
@Builder
@Jacksonized
@Value
public class SecurityContext {

    /**
     * AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process. This bool
     * directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true
     * always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN
     */
    @Nullable
    Boolean allowPrivilegeEscalation;

    @Nullable
    Capabilities capabilities;

    /**
     * Run container in privileged mode. Processes in privileged containers are essentially equivalent to root on the
     * host. Defaults to false.
     */
    @Nullable
    Boolean privileged;

    /**
     * procMount denotes the type of proc mount to use for the containers. The default is DefaultProcMount which uses
     * the container runtime defaults for readonly paths and masked paths. This requires the ProcMountType feature flag
     * to be enabled.
     */
    @Nullable
    String procMount;

    /**
     * Whether this container has a read-only root filesystem. Default is false.
     */
    @Nullable
    Boolean readOnlyRootFilesystem;

    /**
     * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in
     * PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in
     * SecurityContext takes precedence.
     */
    @Nullable
    Long runAsGroup;

    /**
     * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime
     * to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no
     * such validation will be performed. May also be set in PodSecurityContext.  If set in both SecurityContext and
     * PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @Nullable
    Boolean runAsNonRoot;

    /**
     * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if
     * unspecified. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the
     * value specified in SecurityContext takes precedence.
     */
    @Nullable
    Long runAsUser;

    @Nullable
    SELinuxOptions seLinuxOptions;

    @Nullable
    SeccompProfile seccompProfile;

    @Nullable
    WindowsSecurityContextOptions windowsOptions;

}
