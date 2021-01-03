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
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Volume represents a named volume in a pod that may be accessed by any container in the pod.
 */
@Builder
@Jacksonized
@Value
public class Volume {

    @Nullable
    AWSElasticBlockStoreVolumeSource awsElasticBlockStore;

    @Nullable
    AzureDiskVolumeSource azureDisk;

    @Nullable
    AzureFileVolumeSource azureFile;

    @Nullable
    CephFSVolumeSource cephfs;

    @Nullable
    CinderVolumeSource cinder;

    @Nullable
    ConfigMapVolumeSource configMap;

    @Nullable
    CSIVolumeSource csi;

    @Nullable
    DownwardAPIVolumeSource downwardAPI;

    @Nullable
    EmptyDirVolumeSource emptyDir;

    @Nullable
    EphemeralVolumeSource ephemeral;

    @Nullable
    FCVolumeSource fc;

    @Nullable
    FlexVolumeSource flexVolume;

    @Nullable
    FlockerVolumeSource flocker;

    @Nullable
    GCEPersistentDiskVolumeSource gcePersistentDisk;

    @Nullable
    GitRepoVolumeSource gitRepo;

    @Nullable
    GlusterfsVolumeSource glusterfs;

    @Nullable
    HostPathVolumeSource hostPath;

    @Nullable
    ISCSIVolumeSource iscsi;

    /**
     * Volume's name. Must be a DNS_LABEL and unique within the pod. More info:
     * https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     */
    @NonNull
    String name;

    @Nullable
    NFSVolumeSource nfs;

    @Nullable
    PersistentVolumeClaimVolumeSource persistentVolumeClaim;

    @Nullable
    PhotonPersistentDiskVolumeSource photonPersistentDisk;

    @Nullable
    PortworxVolumeSource portworxVolume;

    @Nullable
    ProjectedVolumeSource projected;

    @Nullable
    QuobyteVolumeSource quobyte;

    @Nullable
    RBDVolumeSource rbd;

    @Nullable
    ScaleIOVolumeSource scaleIO;

    @Nullable
    SecretVolumeSource secret;

    @Nullable
    StorageOSVolumeSource storageos;

    @Nullable
    VsphereVirtualDiskVolumeSource vsphereVolume;

}
