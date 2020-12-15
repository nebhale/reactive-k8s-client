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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * PatchOptions may be provided when patching an API object. PatchOptions is meant to be a superset of UpdateOptions.
 */
@Builder
@Jacksonized
@Getter
@EqualsAndHashCode
@ToString
public final class PatchOptions implements TypeMeta {

    @Nullable
    private final String kind;

    @Nullable
    private final String apiVersion;

    /**
     * When present, indicates that modifications should not be persisted. An invalid or unrecognized dryRun directive
     * will result in an error response and no further processing of the request. Valid values are: - All: all dry run
     * stages will be processed
     */
    @Nullable
    @Singular("dryRun")
    private final List<String> dryRun;

    /**
     * Force is going to "force" Apply requests. It means user will re-acquire conflicting fields owned by other people.
     * Force flag must be unset for non-apply patch requests.
     */
    @Nullable
    private final Boolean force;

    /**
     * fieldManager is a name associated with the actor or entity that is making these changes. The value must be less
     * than or 128 characters long, and only contain printable characters, as defined by
     * https://golang.org/pkg/unicode/#IsPrint. This field is required for apply requests (application/apply-patch) but
     * optional for non-apply patch types (JsonPatch, MergePatch, StrategicMergePatch).
     */
    @Nullable
    private final String fieldManager;

}
