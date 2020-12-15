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

package io.k8s.batch.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CronJobSpec describes how the job execution will look like and when it will actually run.
 */
@Builder
@Jacksonized
@Value
public class CronJobSpec {

    /**
     * Specifies how to treat concurrent executions of a Job. Valid values are: - "Allow" (default): allows CronJobs to
     * run concurrently; - "Forbid": forbids concurrent runs, skipping next run if previous run hasn't finished yet; -
     * "Replace": cancels currently running job and replaces it with a new one
     */
    @Nullable
    String concurrencyPolicy;

    /**
     * The number of failed finished jobs to retain. This is a pointer to distinguish between explicit zero and not
     * specified. Defaults to 1.
     */
    @Nullable
    Integer failedJobsHistoryLimit;

    @NonNull
    JobTemplateSpec jobTemplate;

    /**
     * The schedule in Cron format, see https://en.wikipedia.org/wiki/Cron.
     */
    @NonNull
    String schedule;

    /**
     * Optional deadline in seconds for starting the job if it misses scheduled time for any reason.  Missed jobs
     * executions will be counted as failed ones.
     */
    @Nullable
    Long startingDeadlineSeconds;

    /**
     * The number of successful finished jobs to retain. This is a pointer to distinguish between explicit zero and not
     * specified. Defaults to 3.
     */
    @Nullable
    Integer successfulJobsHistoryLimit;

    /**
     * This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.
     * Defaults to false.
     */
    @Nullable
    Boolean suspend;

}
