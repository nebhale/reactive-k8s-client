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
import org.springframework.lang.Nullable;

/**
 * Probe describes a health check to be performed against a container to determine whether it is alive or ready to
 * receive traffic.
 */
@Builder
@Jacksonized
@Value
public class Probe {

    @Nullable
    ExecAction exec;

    /**
     * Minimum consecutive failures for the probe to be considered failed after having succeeded. Defaults to 3. Minimum
     * value is 1.
     */
    @Nullable
    Integer failureThreshold;

    @Nullable
    HTTPGetAction httpGet;

    /**
     * Number of seconds after the container has started before liveness probes are initiated. More info:
     * https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
     */
    @Nullable
    Integer initialDelaySeconds;

    /**
     * How often (in seconds) to perform the probe. Default to 10 seconds. Minimum value is 1.
     */
    @Nullable
    Integer periodSeconds;

    /**
     * Minimum consecutive successes for the probe to be considered successful after having failed. Defaults to 1. Must
     * be 1 for liveness and startup. Minimum value is 1.
     */
    @Nullable
    Integer successThreshold;

    @Nullable
    TCPSocketAction tcpSocket;

    /**
     * Number of seconds after which the probe times out. Defaults to 1 second. Minimum value is 1. More info:
     * https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
     */
    @Nullable
    Integer timeoutSeconds;

}
