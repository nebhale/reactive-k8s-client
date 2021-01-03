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

package io.k8s.discovery.v1beta1;

import io.k8s.core.v1.ObjectReference;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Endpoint represents a single logical "backend" implementing a service.
 */
@Builder
@Jacksonized
@Value
public class Endpoint {

    /**
     * addresses of this endpoint. The contents of this field are interpreted according to the corresponding
     * EndpointSlice addressType field. Consumers must handle different types of addresses in the context of their own
     * capabilities. This must contain at least one address but no more than 100.
     */
    @NonNull
    @Singular
    List<String> addresses;

    @Nullable
    EndpointConditions conditions;

    /**
     * hostname of this endpoint. This field may be used by consumers of endpoints to distinguish endpoints from each
     * other (e.g. in DNS names). Multiple endpoints which use the same hostname should be considered fungible (e.g.
     * multiple A values in DNS). Must pass DNS Label (RFC 1123) validation.
     */
    @Nullable
    String hostname;

    @Nullable
    ObjectReference targetRef;

    /**
     * topology contains arbitrary topology information associated with the endpoint. These key/value pairs must conform
     * with the label format. https://kubernetes.io/docs/concepts/overview/working-with-objects/labels Topology may
     * include a maximum of 16 key/value pairs. This includes, but is not limited to the following well known keys: *
     * kubernetes.io/hostname: the value indicates the hostname of the node
     *   where the endpoint is located. This should
     * match the corresponding
     *   node label.
     * * topology.kubernetes.io/zone: the value indicates the zone where the
     *  
     * endpoint is located. This should match the corresponding node label.
     * * topology.kubernetes.io/region: the value
     * indicates the region where the
     *   endpoint is located. This should match the corresponding node label.
     */
    @Nullable
    @Singular("topology")
    Map<String, String> topology;

}
