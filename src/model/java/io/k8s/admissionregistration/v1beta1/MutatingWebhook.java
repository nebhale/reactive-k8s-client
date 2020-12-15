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

package io.k8s.admissionregistration.v1beta1;

import io.k8s.meta.v1.LabelSelector;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * MutatingWebhook describes an admission webhook and the resources and operations it applies to.
 */
@Builder
@Jacksonized
@Value
public class MutatingWebhook {

    /**
     * AdmissionReviewVersions is an ordered list of preferred `AdmissionReview` versions the Webhook expects. API
     * server will try to use first version in the list which it supports. If none of the versions specified in this
     * list supported by API server, validation will fail for this object. If a persisted webhook configuration
     * specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will
     * fail and be subject to the failure policy. Default to `['v1beta1']`.
     */
    @Nullable
    @Singular
    List<String> admissionReviewVersions;

    @NonNull
    WebhookClientConfig clientConfig;

    /**
     * FailurePolicy defines how unrecognized errors from the admission endpoint are handled - allowed values are Ignore
     * or Fail. Defaults to Ignore.
     */
    @Nullable
    String failurePolicy;

    /**
     * matchPolicy defines how the "rules" list is used to match incoming requests. Allowed values are "Exact" or
     * "Equivalent".
     * 
     * - Exact: match a request only if it exactly matches a specified rule. For example, if deployments
     * can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, but "rules" only included `apiGroups:["apps"],
     * apiVersions:["v1"], resources: ["deployments"]`, a request to apps/v1beta1 or extensions/v1beta1 would not be
     * sent to the webhook.
     * 
     * - Equivalent: match a request if modifies a resource listed in rules, even via another API
     * group or version. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1,
     * and "rules" only included `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]`, a request to
     * apps/v1beta1 or extensions/v1beta1 would be converted to apps/v1 and sent to the webhook.
     * 
     * Defaults to "Exact"
     */
    @Nullable
    String matchPolicy;

    /**
     * The name of the admission webhook. Name should be fully qualified, e.g., imagepolicy.kubernetes.io, where
     * "imagepolicy" is the name of the webhook, and kubernetes.io is the name of the organization. Required.
     */
    @NonNull
    String name;

    @Nullable
    LabelSelector namespaceSelector;

    @Nullable
    LabelSelector objectSelector;

    /**
     * reinvocationPolicy indicates whether this webhook should be called multiple times as part of a single admission
     * evaluation. Allowed values are "Never" and "IfNeeded".
     * 
     * Never: the webhook will not be called more than once in a
     * single admission evaluation.
     * 
     * IfNeeded: the webhook will be called at least one additional time as part of the
     * admission evaluation if the object being admitted is modified by other admission plugins after the initial
     * webhook call. Webhooks that specify this option *must* be idempotent, able to process objects they previously
     * admitted. Note: * the number of additional invocations is not guaranteed to be exactly one. * if additional
     * invocations result in further modifications to the object, webhooks are not guaranteed to be invoked again. *
     * webhooks that use this option may be reordered to minimize the number of additional invocations. * to validate an
     * object after all mutations are guaranteed complete, use a validating admission webhook instead.
     * 
     * Defaults to
     * "Never".
     */
    @Nullable
    String reinvocationPolicy;

    /**
     * Rules describes what operations on what resources/subresources the webhook cares about. The webhook cares about
     * an operation if it matches _any_ Rule. However, in order to prevent ValidatingAdmissionWebhooks and
     * MutatingAdmissionWebhooks from putting the cluster in a state which cannot be recovered from without completely
     * disabling the plugin, ValidatingAdmissionWebhooks and MutatingAdmissionWebhooks are never called on admission
     * requests for ValidatingWebhookConfiguration and MutatingWebhookConfiguration objects.
     */
    @Nullable
    @Singular
    List<RuleWithOperations> rules;

    /**
     * SideEffects states whether this webhook has side effects. Acceptable values are: Unknown, None, Some,
     * NoneOnDryRun Webhooks with side effects MUST implement a reconciliation system, since a request may be rejected
     * by a future step in the admission change and the side effects therefore need to be undone. Requests with the
     * dryRun attribute will be auto-rejected if they match a webhook with sideEffects == Unknown or Some. Defaults to
     * Unknown.
     */
    @Nullable
    String sideEffects;

    /**
     * TimeoutSeconds specifies the timeout for this webhook. After the timeout passes, the webhook call will be ignored
     * or the API call will fail based on the failure policy. The timeout value must be between 1 and 30 seconds.
     * Default to 30 seconds.
     */
    @Nullable
    Integer timeoutSeconds;

}
