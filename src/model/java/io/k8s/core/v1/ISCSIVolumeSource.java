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
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Represents an ISCSI disk. ISCSI volumes can only be mounted as read/write once. ISCSI volumes support ownership
 * management and SELinux relabeling.
 */
@Builder
@Jacksonized
@Value
public class ISCSIVolumeSource {

    /**
     * whether support iSCSI Discovery CHAP authentication
     */
    @Nullable
    Boolean chapAuthDiscovery;

    /**
     * whether support iSCSI Session CHAP authentication
     */
    @Nullable
    Boolean chapAuthSession;

    /**
     * Filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the
     * host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More
     * info: https://kubernetes.io/docs/concepts/storage/volumes#iscsi
     */
    @Nullable
    String fsType;

    /**
     * Custom iSCSI Initiator Name. If initiatorName is specified with iscsiInterface simultaneously, new iSCSI
     * interface <target portal>:<volume name> will be created for the connection.
     */
    @Nullable
    String initiatorName;

    /**
     * Target iSCSI Qualified Name.
     */
    @NonNull
    String iqn;

    /**
     * iSCSI Interface Name that uses an iSCSI transport. Defaults to 'default' (tcp).
     */
    @Nullable
    String iscsiInterface;

    /**
     * iSCSI Target Lun number.
     */
    @NonNull
    Integer lun;

    /**
     * iSCSI Target Portal List. The portal is either an IP or ip_addr:port if the port is other than default (typically
     * TCP ports 860 and 3260).
     */
    @Nullable
    @Singular
    List<String> portals;

    /**
     * ReadOnly here will force the ReadOnly setting in VolumeMounts. Defaults to false.
     */
    @Nullable
    Boolean readOnly;

    @Nullable
    LocalObjectReference secretRef;

    /**
     * iSCSI Target Portal. The Portal is either an IP or ip_addr:port if the port is other than default (typically TCP
     * ports 860 and 3260).
     */
    @NonNull
    String targetPortal;

}
