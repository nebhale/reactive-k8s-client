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

package io.k8s.meta.v1;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * CreateOptions may be provided when creating an API object.
 */
@Builder
@Jacksonized
@Value
public class CreateOptions implements TypeMeta {

    @Nullable
    String kind;

    @Nullable
    String apiVersion;

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive
     * will result in an error response and no further processing of the request. Valid values are: - All: all dry run
     * stages will be processed
     */
    @Nullable
    @Singular("dryRun")
    List<String> dryRun;

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less
     * than or 128 characters long, and only contain printable characters, as defined by
     * https://golang.org/pkg/unicode/#IsPrint.
     */
    @Nullable
    String fieldManager;

}
