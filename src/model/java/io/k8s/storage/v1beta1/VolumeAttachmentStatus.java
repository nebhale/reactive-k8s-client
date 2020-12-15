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

package io.k8s.storage.v1beta1;

import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * VolumeAttachmentStatus is the status of a VolumeAttachment request.
 */
@Builder
@Jacksonized
@Value
public class VolumeAttachmentStatus {

    @Nullable
    VolumeError attachError;

    /**
     * Indicates the volume is successfully attached. This field must only be set by the entity completing the attach
     * operation, i.e. the external-attacher.
     */
    @NonNull
    Boolean attached;

    /**
     * Upon successful attach, this field is populated with any information returned by the attach operation that must
     * be passed into subsequent WaitForAttach or Mount calls. This field must only be set by the entity completing the
     * attach operation, i.e. the external-attacher.
     */
    @Nullable
    @Singular("attachmentMetadata")
    Map<String, String> attachmentMetadata;

    @Nullable
    VolumeError detachError;

}
