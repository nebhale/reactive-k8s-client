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

package io.k8s.storage.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

/**
 * VolumeAttachmentSpec is the specification of a VolumeAttachment request.
 */
@Builder
@Jacksonized
@Value
public class VolumeAttachmentSpec {

    /**
     * Attacher indicates the name of the volume driver that MUST handle this request. This is the name returned by
     * GetPluginName().
     */
    @NonNull
    String attacher;

    /**
     * The node that the volume should be attached to.
     */
    @NonNull
    String nodeName;

    @NonNull
    VolumeAttachmentSource source;

}
