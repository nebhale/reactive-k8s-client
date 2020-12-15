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

package io.k8s.core.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Represents a Persistent Disk resource in AWS.
 * 
 * An AWS EBS disk must exist before mounting to a container. The disk
 * must also be in the same AWS zone as the kubelet. An AWS EBS disk can only be mounted as read/write once. AWS EBS
 * volumes support ownership management and SELinux relabeling.
 */
@Builder
@Jacksonized
@Value
public class AWSElasticBlockStoreVolumeSource {

    /**
     * Filesystem type of the volume that you want to mount. Tip: Ensure that the filesystem type is supported by the
     * host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More
     * info: https://kubernetes.io/docs/concepts/storage/volumes#awselasticblockstore
     */
    @Nullable
    String fsType;

    /**
     * The partition in the volume that you want to mount. If omitted, the default is to mount by volume name. Examples:
     * For volume /dev/sda1, you specify the partition as "1". Similarly, the volume partition for /dev/sda is "0" (or
     * you can leave the property empty).
     */
    @Nullable
    Integer partition;

    /**
     * Specify "true" to force and set the ReadOnly property in VolumeMounts to "true". If omitted, the default is
     * "false". More info: https://kubernetes.io/docs/concepts/storage/volumes#awselasticblockstore
     */
    @Nullable
    Boolean readOnly;

    /**
     * Unique ID of the persistent disk resource in AWS (Amazon EBS volume). More info:
     * https://kubernetes.io/docs/concepts/storage/volumes#awselasticblockstore
     */
    @NonNull
    String volumeID;

}
