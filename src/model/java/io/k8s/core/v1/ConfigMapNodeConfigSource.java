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
 * ConfigMapNodeConfigSource contains the information to reference a ConfigMap as a config source for the Node.
 */
@Builder
@Jacksonized
@Value
public class ConfigMapNodeConfigSource {

    /**
     * KubeletConfigKey declares which key of the referenced ConfigMap corresponds to the KubeletConfiguration structure
     * This field is required in all cases.
     */
    @NonNull
    String kubeletConfigKey;

    /**
     * Name is the metadata.name of the referenced ConfigMap. This field is required in all cases.
     */
    @NonNull
    String name;

    /**
     * Namespace is the metadata.namespace of the referenced ConfigMap. This field is required in all cases.
     */
    @NonNull
    String namespace;

    /**
     * ResourceVersion is the metadata.ResourceVersion of the referenced ConfigMap. This field is forbidden in
     * Node.Spec, and required in Node.Status.
     */
    @Nullable
    String resourceVersion;

    /**
     * UID is the metadata.UID of the referenced ConfigMap. This field is forbidden in Node.Spec, and required in
     * Node.Status.
     */
    @Nullable
    String uid;

}
