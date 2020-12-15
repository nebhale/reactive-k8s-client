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
 * Represents a Quobyte mount that lasts the lifetime of a pod. Quobyte volumes do not support ownership management or
 * SELinux relabeling.
 */
@Builder
@Jacksonized
@Value
public class QuobyteVolumeSource {

    /**
     * Group to map volume access to Default is no group
     */
    @Nullable
    String group;

    /**
     * ReadOnly here will force the Quobyte volume to be mounted with read-only permissions. Defaults to false.
     */
    @Nullable
    Boolean readOnly;

    /**
     * Registry represents a single or multiple Quobyte Registry services specified as a string as host:port pair
     * (multiple entries are separated with commas) which acts as the central registry for volumes
     */
    @NonNull
    String registry;

    /**
     * Tenant owning the given Quobyte volume in the Backend Used with dynamically provisioned Quobyte volumes, value is
     * set by the plugin
     */
    @Nullable
    String tenant;

    /**
     * User to map volume access to Defaults to serivceaccount user
     */
    @Nullable
    String user;

    /**
     * Volume is a string that references an already created Quobyte volume by name.
     */
    @NonNull
    String volume;

}
