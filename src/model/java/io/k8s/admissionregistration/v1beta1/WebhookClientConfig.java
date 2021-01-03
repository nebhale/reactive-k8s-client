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

package io.k8s.admissionregistration.v1beta1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * WebhookClientConfig contains the information to make a TLS connection with the webhook
 */
@Builder
@Jacksonized
@Value
public class WebhookClientConfig {

    /**
     * `caBundle` is a PEM encoded CA bundle which will be used to validate the webhook's server certificate. If
     * unspecified, system trust roots on the apiserver are used.
     */
    @Nullable
    String caBundle;

    @Nullable
    ServiceReference service;

    /**
     * `url` gives the location of the webhook, in standard URL form (`scheme://host:port/path`). Exactly one of `url`
     * or `service` must be specified.
     * 
     * The `host` should not refer to a service running in the cluster; use the
     * `service` field instead. The host might be resolved via external DNS in some apiservers (e.g., `kube-apiserver`
     * cannot resolve in-cluster DNS as that would be a layering violation). `host` may also be an IP address.
     * 
     * Please
     * note that using `localhost` or `127.0.0.1` as a `host` is risky unless you take great care to run this webhook on
     * all hosts which run an apiserver which might need to make calls to this webhook. Such installs are likely to be
     * non-portable, i.e., not easy to turn up in a new cluster.
     * 
     * The scheme must be "https"; the URL must begin with
     * "https://".
     * 
     * A path is optional, and if present may be any string permissible in a URL. You may use the path to
     * pass an arbitrary string to the webhook, for example, a cluster identifier.
     * 
     * Attempting to use a user or basic
     * auth e.g. "user:password@" is not allowed. Fragments ("#...") and query parameters ("?...") are not allowed,
     * either.
     */
    @Nullable
    String url;

}
