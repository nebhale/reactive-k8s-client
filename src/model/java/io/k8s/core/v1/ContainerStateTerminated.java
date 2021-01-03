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

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * ContainerStateTerminated is a terminated state of a container.
 */
@Builder
@Jacksonized
@Value
public class ContainerStateTerminated {

    /**
     * Container's ID in the format 'docker://<container_id>'
     */
    @Nullable
    String containerID;

    /**
     * Exit status from the last termination of the container
     */
    @NonNull
    Integer exitCode;

    @Nullable
    OffsetDateTime finishedAt;

    /**
     * Message regarding the last termination of the container
     */
    @Nullable
    String message;

    /**
     * (brief) reason from the last termination of the container
     */
    @Nullable
    String reason;

    /**
     * Signal from the last termination of the container
     */
    @Nullable
    Integer signal;

    @Nullable
    OffsetDateTime startedAt;

}
