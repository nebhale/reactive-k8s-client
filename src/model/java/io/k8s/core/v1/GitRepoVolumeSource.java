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
 * Represents a volume that is populated with the contents of a git repository. Git repo volumes do not support
 * ownership management. Git repo volumes support SELinux relabeling.
 * 
 * DEPRECATED: GitRepo is deprecated. To provision a
 * container with a git repo, mount an EmptyDir into an InitContainer that clones the repo using git, then mount the
 * EmptyDir into the Pod's container.
 */
@Builder
@Jacksonized
@Value
public class GitRepoVolumeSource {

    /**
     * Target directory name. Must not contain or start with '..'.  If '.' is supplied, the volume directory will be the
     * git repository.  Otherwise, if specified, the volume will contain the git repository in the subdirectory with the
     * given name.
     */
    @Nullable
    String directory;

    /**
     * Repository URL
     */
    @NonNull
    String repository;

    /**
     * Commit hash for the specified revision.
     */
    @Nullable
    String revision;

}
