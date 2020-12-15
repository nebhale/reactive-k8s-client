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

package io.k8s.policy.v1beta1;

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * PodSecurityPolicySpec defines the policy enforced.
 */
@Builder
@Jacksonized
@Value
public class PodSecurityPolicySpec {

    /**
     * allowPrivilegeEscalation determines if a pod can request to allow privilege escalation. If unspecified, defaults
     * to true.
     */
    @Nullable
    Boolean allowPrivilegeEscalation;

    /**
     * AllowedCSIDrivers is an allowlist of inline CSI drivers that must be explicitly set to be embedded within a pod
     * spec. An empty value indicates that any CSI driver can be used for inline ephemeral volumes. This is a beta
     * field, and is only honored if the API server enables the CSIInlineVolume feature gate.
     */
    @Nullable
    @Singular
    List<AllowedCSIDriver> allowedCSIDrivers;

    /**
     * allowedCapabilities is a list of capabilities that can be requested to add to the container. Capabilities in this
     * field may be added at the pod author's discretion. You must not list a capability in both allowedCapabilities and
     * requiredDropCapabilities.
     */
    @Nullable
    @Singular
    List<String> allowedCapabilities;

    /**
     * allowedFlexVolumes is an allowlist of Flexvolumes.  Empty or nil indicates that all Flexvolumes may be used. 
     * This parameter is effective only when the usage of the Flexvolumes is allowed in the "volumes" field.
     */
    @Nullable
    @Singular
    List<AllowedFlexVolume> allowedFlexVolumes;

    /**
     * allowedHostPaths is an allowlist of host paths. Empty indicates that all host paths may be used.
     */
    @Nullable
    @Singular
    List<AllowedHostPath> allowedHostPaths;

    /**
     * AllowedProcMountTypes is an allowlist of allowed ProcMountTypes. Empty or nil indicates that only the
     * DefaultProcMountType may be used. This requires the ProcMountType feature flag to be enabled.
     */
    @Nullable
    @Singular
    List<String> allowedProcMountTypes;

    /**
     * allowedUnsafeSysctls is a list of explicitly allowed unsafe sysctls, defaults to none. Each entry is either a
     * plain sysctl name or ends in "*" in which case it is considered as a prefix of allowed sysctls. Single * means
     * all unsafe sysctls are allowed. Kubelet has to allowlist all allowed unsafe sysctls explicitly to avoid
     * rejection.
     * 
     * Examples: e.g. "foo/*" allows "foo/bar", "foo/baz", etc. e.g. "foo.*" allows "foo.bar", "foo.baz",
     * etc.
     */
    @Nullable
    @Singular
    List<String> allowedUnsafeSysctls;

    /**
     * defaultAddCapabilities is the default set of capabilities that will be added to the container unless the pod spec
     * specifically drops the capability.  You may not list a capability in both defaultAddCapabilities and
     * requiredDropCapabilities. Capabilities added here are implicitly allowed, and need not be included in the
     * allowedCapabilities list.
     */
    @Nullable
    @Singular
    List<String> defaultAddCapabilities;

    /**
     * defaultAllowPrivilegeEscalation controls the default setting for whether a process can gain more privileges than
     * its parent process.
     */
    @Nullable
    Boolean defaultAllowPrivilegeEscalation;

    /**
     * forbiddenSysctls is a list of explicitly forbidden sysctls, defaults to none. Each entry is either a plain sysctl
     * name or ends in "*" in which case it is considered as a prefix of forbidden sysctls. Single * means all sysctls
     * are forbidden.
     * 
     * Examples: e.g. "foo/*" forbids "foo/bar", "foo/baz", etc. e.g. "foo.*" forbids "foo.bar",
     * "foo.baz", etc.
     */
    @Nullable
    @Singular
    List<String> forbiddenSysctls;

    @NonNull
    FSGroupStrategyOptions fsGroup;

    /**
     * hostIPC determines if the policy allows the use of HostIPC in the pod spec.
     */
    @Nullable
    Boolean hostIPC;

    /**
     * hostNetwork determines if the policy allows the use of HostNetwork in the pod spec.
     */
    @Nullable
    Boolean hostNetwork;

    /**
     * hostPID determines if the policy allows the use of HostPID in the pod spec.
     */
    @Nullable
    Boolean hostPID;

    /**
     * hostPorts determines which host port ranges are allowed to be exposed.
     */
    @Nullable
    @Singular
    List<HostPortRange> hostPorts;

    /**
     * privileged determines if a pod can request to be run as privileged.
     */
    @Nullable
    Boolean privileged;

    /**
     * readOnlyRootFilesystem when set to true will force containers to run with a read only root file system.  If the
     * container specifically requests to run with a non-read only root file system the PSP should deny the pod. If set
     * to false the container may run with a read only root file system if it wishes but it will not be forced to.
     */
    @Nullable
    Boolean readOnlyRootFilesystem;

    /**
     * requiredDropCapabilities are the capabilities that will be dropped from the container.  These are required to be
     * dropped and cannot be added.
     */
    @Nullable
    @Singular
    List<String> requiredDropCapabilities;

    @Nullable
    RunAsGroupStrategyOptions runAsGroup;

    @NonNull
    RunAsUserStrategyOptions runAsUser;

    @Nullable
    RuntimeClassStrategyOptions runtimeClass;

    @NonNull
    SELinuxStrategyOptions seLinux;

    @NonNull
    SupplementalGroupsStrategyOptions supplementalGroups;

    /**
     * volumes is an allowlist of volume plugins. Empty indicates that no volumes may be used. To allow all volumes you
     * may use '*'.
     */
    @Nullable
    @Singular
    List<String> volumes;

}
