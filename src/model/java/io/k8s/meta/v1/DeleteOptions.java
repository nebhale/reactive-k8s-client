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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * DeleteOptions may be provided when deleting an API object.
 */
@Builder
@Jacksonized
@Value
public class DeleteOptions implements TypeMeta {

    public static final String GROUP = "";

    public static final String KIND = "DeleteOptions";

    public static final String VERSION = "v1";

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized
     * schemas to the latest internal value, and may reject unrecognized values. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
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
     * The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero
     * indicates delete immediately. If this value is nil, the default grace period for the specified type will be used.
     * Defaults to a per object value if not specified. zero means delete immediately.
     */
    @Nullable
    Long gracePeriodSeconds;

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the
     * endpoint the client submits requests to. Cannot be updated. In CamelCase. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @Nullable
    String kind;

    @Nullable
    Preconditions preconditions;

    /**
     * Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not
     * both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the
     * resource-specific default policy. Acceptable values are: 'Orphan' - orphan the dependents; 'Background' - allow
     * the garbage collector to delete the dependents in the background; 'Foreground' - a cascading policy that deletes
     * all dependents in the foreground.
     */
    @Nullable
    String propagationPolicy;

}
