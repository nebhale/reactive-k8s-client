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
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * PersistentVolumeSpec is the specification of a persistent volume.
 */
@Builder
@Jacksonized
@Value
public class PersistentVolumeSpec {

    /**
     * AccessModes contains all ways the volume can be mounted. More info:
     * https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes
     */
    @Nullable
    @Singular
    List<String> accessModes;

    @Nullable
    AWSElasticBlockStoreVolumeSource awsElasticBlockStore;

    @Nullable
    AzureDiskVolumeSource azureDisk;

    @Nullable
    AzureFilePersistentVolumeSource azureFile;

    /**
     * A description of the persistent volume's resources and capacity. More info:
     * https://kubernetes.io/docs/concepts/storage/persistent-volumes#capacity
     */
    @Nullable
    @Singular("capacity")
    Map<String, String> capacity;

    @Nullable
    CephFSPersistentVolumeSource cephfs;

    @Nullable
    CinderPersistentVolumeSource cinder;

    @Nullable
    ObjectReference claimRef;

    @Nullable
    CSIPersistentVolumeSource csi;

    @Nullable
    FCVolumeSource fc;

    @Nullable
    FlexPersistentVolumeSource flexVolume;

    @Nullable
    FlockerVolumeSource flocker;

    @Nullable
    GCEPersistentDiskVolumeSource gcePersistentDisk;

    @Nullable
    GlusterfsPersistentVolumeSource glusterfs;

    @Nullable
    HostPathVolumeSource hostPath;

    @Nullable
    ISCSIPersistentVolumeSource iscsi;

    @Nullable
    LocalVolumeSource local;

    /**
     * A list of mount options, e.g. ["ro", "soft"]. Not validated - mount will simply fail if one is invalid. More
     * info: https://kubernetes.io/docs/concepts/storage/persistent-volumes/#mount-options
     */
    @Nullable
    @Singular
    List<String> mountOptions;

    @Nullable
    NFSVolumeSource nfs;

    @Nullable
    VolumeNodeAffinity nodeAffinity;

    @Nullable
    PhotonPersistentDiskVolumeSource photonPersistentDisk;

    @Nullable
    PortworxVolumeSource portworxVolume;

    @Nullable
    QuobyteVolumeSource quobyte;

    @Nullable
    RBDPersistentVolumeSource rbd;

    @Nullable
    ScaleIOPersistentVolumeSource scaleIO;

    /**
     * Name of StorageClass to which this persistent volume belongs. Empty value means that this volume does not belong
     * to any StorageClass.
     */
    @Nullable
    String storageClassName;

    @Nullable
    StorageOSPersistentVolumeSource storageos;

    /**
     * volumeMode defines if a volume is intended to be used with a formatted filesystem or to remain in raw block
     * state. Value of Filesystem is implied when not included in spec.
     */
    @Nullable
    String volumeMode;

    @Nullable
    VsphereVirtualDiskVolumeSource vsphereVolume;

}
