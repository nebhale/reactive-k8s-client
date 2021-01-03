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

import io.k8s.core.v1.PodTemplateSpec;
import io.k8s.meta.v1.LabelSelector;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * JobSpec describes how the job execution will look like.
 */
@Builder
@Jacksonized
@Value
public class JobSpec {

    /**
     * Specifies the duration in seconds relative to the startTime that the job may be active before the system tries to
     * terminate it; value must be positive integer
     */
    @Nullable
    Long activeDeadlineSeconds;

    /**
     * Specifies the number of retries before marking this job failed. Defaults to 6
     */
    @Nullable
    Integer backoffLimit;

    /**
     * Specifies the desired number of successfully finished pods the job should be run with.  Setting to nil means that
     * the success of any pod signals the success of all pods, and allows parallelism to have any positive value. 
     * Setting to 1 means that parallelism is limited to 1 and the success of that pod signals the success of the job.
     * More info: https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @Nullable
    Integer completions;

    /**
     * manualSelector controls generation of pod labels and pod selectors. Leave `manualSelector` unset unless you are
     * certain what you are doing. When false or unset, the system pick labels unique to this job and appends those
     * labels to the pod template.  When true, the user is responsible for picking unique labels and specifying the
     * selector.  Failure to pick a unique label may cause this and other jobs to not function correctly.  However, You
     * may see `manualSelector=true` in jobs that were created with the old `extensions/v1beta1` API. More info:
     * https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/#specifying-your-own-pod-selector
     */
    @Nullable
    Boolean manualSelector;

    /**
     * Specifies the maximum desired number of pods the job should run at any given time. The actual number of pods
     * running in steady state will be less than this number when ((.spec.completions - .status.successful) <
     * .spec.parallelism), i.e. when the work left to do is less than max parallelism. More info:
     * https://kubernetes.io/docs/concepts/workloads/controllers/jobs-run-to-completion/
     */
    @Nullable
    Integer parallelism;

    @Nullable
    LabelSelector selector;

    @NonNull
    PodTemplateSpec template;

    /**
     * ttlSecondsAfterFinished limits the lifetime of a Job that has finished execution (either Complete or Failed). If
     * this field is set, ttlSecondsAfterFinished after the Job finishes, it is eligible to be automatically deleted.
     * When the Job is being deleted, its lifecycle guarantees (e.g. finalizers) will be honored. If this field is
     * unset, the Job won't be automatically deleted. If this field is set to zero, the Job becomes eligible to be
     * deleted immediately after it finishes. This field is alpha-level and is only honored by servers that enable the
     * TTLAfterFinished feature.
     */
    @Nullable
    Integer ttlSecondsAfterFinished;

}
