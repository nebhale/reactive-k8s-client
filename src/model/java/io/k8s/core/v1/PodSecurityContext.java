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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * PodSecurityContext holds pod-level security attributes and common container settings. Some fields are also present in
 * container.securityContext.  Field values of container.securityContext take precedence over field values of
 * PodSecurityContext.
 */
@Builder
@Jacksonized
@Value
public class PodSecurityContext {

    /**
     * A special supplemental group that applies to all containers in a pod. Some volume types allow the Kubelet to
     * change the ownership of that volume to be owned by the pod:
     * 
     * 1. The owning GID will be the FSGroup 2. The setgid
     * bit is set (new files created in the volume will be owned by FSGroup) 3. The permission bits are OR'd with
     * rw-rw----
     * 
     * If unset, the Kubelet will not modify the ownership and permissions of any volume.
     */
    @Nullable
    Long fsGroup;

    /**
     * fsGroupChangePolicy defines behavior of changing ownership and permission of the volume before being exposed
     * inside Pod. This field will only apply to volume types which support fsGroup based ownership(and permissions). It
     * will have no effect on ephemeral volume types such as: secret, configmaps and emptydir. Valid values are
     * "OnRootMismatch" and "Always". If not specified defaults to "Always".
     */
    @Nullable
    String fsGroupChangePolicy;

    /**
     * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in
     * SecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext
     * takes precedence for that container.
     */
    @Nullable
    Long runAsGroup;

    /**
     * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime
     * to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no
     * such validation will be performed. May also be set in SecurityContext.  If set in both SecurityContext and
     * PodSecurityContext, the value specified in SecurityContext takes precedence.
     */
    @Nullable
    Boolean runAsNonRoot;

    /**
     * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if
     * unspecified. May also be set in SecurityContext.  If set in both SecurityContext and PodSecurityContext, the
     * value specified in SecurityContext takes precedence for that container.
     */
    @Nullable
    Long runAsUser;

    @Nullable
    SELinuxOptions seLinuxOptions;

    @Nullable
    SeccompProfile seccompProfile;

    /**
     * A list of groups applied to the first process run in each container, in addition to the container's primary GID. 
     * If unspecified, no groups will be added to any container.
     */
    @Nullable
    @Singular
    List<Long> supplementalGroups;

    /**
     * Sysctls hold a list of namespaced sysctls used for the pod. Pods with unsupported sysctls (by the container
     * runtime) might fail to launch.
     */
    @Nullable
    @Singular
    List<Sysctl> sysctls;

    @Nullable
    WindowsSecurityContextOptions windowsOptions;

}
