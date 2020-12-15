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

import io.k8s.meta.v1.LabelSelector;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * PersistentVolumeClaimSpec describes the common attributes of storage devices and allows a Source for
 * provider-specific attributes
 */
@Builder
@Jacksonized
@Value
public class PersistentVolumeClaimSpec {

    /**
     * AccessModes contains the desired access modes the volume should have. More info:
     * https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes-1
     */
    @Nullable
    @Singular
    List<String> accessModes;

    @Nullable
    TypedLocalObjectReference dataSource;

    @Nullable
    ResourceRequirements resources;

    @Nullable
    LabelSelector selector;

    /**
     * Name of the StorageClass required by the claim. More info:
     * https://kubernetes.io/docs/concepts/storage/persistent-volumes#class-1
     */
    @Nullable
    String storageClassName;

    /**
     * volumeMode defines what type of volume is required by the claim. Value of Filesystem is implied when not included
     * in claim spec.
     */
    @Nullable
    String volumeMode;

    /**
     * VolumeName is the binding reference to the PersistentVolume backing this claim.
     */
    @Nullable
    String volumeName;

}
