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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * Adapts a secret into a projected volume.
 * 
 * The contents of the target Secret's Data field will be presented in a
 * projected volume as files using the keys in the Data field as the file names. Note that this is identical to a secret
 * volume source without the default mode.
 */
@Builder
@Jacksonized
@Value
public class SecretProjection {

    /**
     * If unspecified, each key-value pair in the Data field of the referenced Secret will be projected into the volume
     * as a file whose name is the key and content is the value. If specified, the listed keys will be projected into
     * the specified paths, and unlisted keys will not be present. If a key is specified which is not present in the
     * Secret, the volume setup will error unless it is marked optional. Paths must be relative and may not contain the
     * '..' path or start with '..'.
     */
    @Nullable
    @Singular
    List<KeyToPath> items;

    /**
     * Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     */
    @Nullable
    String name;

    /**
     * Specify whether the Secret or its key must be defined
     */
    @Nullable
    Boolean optional;

}
