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

import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ExecAction describes a "run in container" action.
 */
@Builder
@Jacksonized
@Value
public class ExecAction {

    /**
     * Command is the command line to execute inside the container, the working directory for the command  is root ('/')
     * in the container's filesystem. The command is simply exec'd, it is not run inside a shell, so traditional shell
     * instructions ('|', etc) won't work. To use a shell, you need to explicitly call out to that shell. Exit status of
     * 0 is treated as live/healthy and non-zero is unhealthy.
     */
    @Nullable
    @Singular("command")
    List<String> command;

}
