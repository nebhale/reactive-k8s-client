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
 * ContainerStatus contains details for the current status of this container.
 */
@Builder
@Jacksonized
@Value
public class ContainerStatus {

    /**
     * Container's ID in the format 'docker://<container_id>'.
     */
    @Nullable
    String containerID;

    /**
     * The image the container is running. More info: https://kubernetes.io/docs/concepts/containers/images
     */
    @NonNull
    String image;

    /**
     * ImageID of the container's image.
     */
    @NonNull
    String imageID;

    @Nullable
    ContainerState lastState;

    /**
     * This must be a DNS_LABEL. Each container in a pod must have a unique name. Cannot be updated.
     */
    @NonNull
    String name;

    /**
     * Specifies whether the container has passed its readiness probe.
     */
    @NonNull
    Boolean ready;

    /**
     * The number of times the container has been restarted, currently based on the number of dead containers that have
     * not yet been removed. Note that this is calculated from dead containers. But those containers are subject to
     * garbage collection. This value will get capped at 5 by GC.
     */
    @NonNull
    Integer restartCount;

    /**
     * Specifies whether the container has passed its startup probe. Initialized as false, becomes true after
     * startupProbe is considered successful. Resets to false when the container is restarted, or if kubelet loses state
     * temporarily. Is always true when no startupProbe is defined.
     */
    @Nullable
    Boolean started;

    @Nullable
    ContainerState state;

}
