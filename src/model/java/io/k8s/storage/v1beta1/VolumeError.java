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

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * VolumeError captures an error encountered during a volume operation.
 */
@Builder
@Jacksonized
@Value
public class VolumeError {

    /**
     * String detailing the error encountered during Attach or Detach operation. This string may be logged, so it should
     * not contain sensitive information.
     */
    @Nullable
    String message;

    @Nullable
    OffsetDateTime time;

}
