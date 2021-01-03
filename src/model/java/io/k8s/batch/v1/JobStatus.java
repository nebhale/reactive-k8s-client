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

package io.k8s.batch.v1;

import java.time.OffsetDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * JobStatus represents the current state of a Job.
 */
@Builder
@Jacksonized
@Value
public class JobStatus {

    /**
     * The number of actively running pods.
     */
    @Nullable
    Integer active;

    @Nullable
    OffsetDateTime completionTime;

    /**
     * The latest available observations of an object's current state. More info:
     * https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @Nullable
    @Singular
    List<JobCondition> conditions;

    /**
     * The number of pods which reached phase Failed.
     */
    @Nullable
    Integer failed;

    @Nullable
    OffsetDateTime startTime;

    /**
     * The number of pods which reached phase Succeeded.
     */
    @Nullable
    Integer succeeded;

}
