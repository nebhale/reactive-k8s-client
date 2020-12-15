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

package io.k8s.apiregistration.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * APIServiceSpec contains information for locating and communicating with a server. Only https is supported, though you
 * are able to disable certificate verification.
 */
@Builder
@Jacksonized
@Value
public class APIServiceSpec {

    /**
     * CABundle is a PEM encoded CA bundle which will be used to validate an API server's serving certificate. If
     * unspecified, system trust roots on the apiserver are used.
     */
    @Nullable
    String caBundle;

    /**
     * Group is the API group name this server hosts
     */
    @Nullable
    String group;

    /**
     * GroupPriorityMininum is the priority this group should have at least. Higher priority means that the group is
     * preferred by clients over lower priority ones. Note that other versions of this group might specify even higher
     * GroupPriorityMininum values such that the whole group gets a higher priority. The primary sort is based on
     * GroupPriorityMinimum, ordered highest number to lowest (20 before 10). The secondary sort is based on the
     * alphabetical comparison of the name of the object.  (v1.bar before v1.foo) We'd recommend something like:
     * *.k8s.io (except extensions) at 18000 and PaaSes (OpenShift, Deis) are recommended to be in the 2000s
     */
    @NonNull
    Integer groupPriorityMinimum;

    /**
     * InsecureSkipTLSVerify disables TLS certificate verification when communicating with this server. This is strongly
     * discouraged.  You should use the CABundle instead.
     */
    @Nullable
    Boolean insecureSkipTLSVerify;

    @Nullable
    ServiceReference service;

    /**
     * Version is the API version this server hosts.  For example, "v1"
     */
    @Nullable
    String version;

    /**
     * VersionPriority controls the ordering of this API version inside of its group.  Must be greater than zero. The
     * primary sort is based on VersionPriority, ordered highest to lowest (20 before 10). Since it's inside of a group,
     * the number can be small, probably in the 10s. In case of equal version priorities, the version string will be
     * used to compute the order inside a group. If the version string is "kube-like", it will sort above non
     * "kube-like" version strings, which are ordered lexicographically. "Kube-like" versions start with a "v", then are
     * followed by a number (the major version), then optionally the string "alpha" or "beta" and another number (the
     * minor version). These are sorted first by GA > beta > alpha (where GA is a version with no suffix such as beta or
     * alpha), and then by comparing major version, then minor version. An example sorted list of versions: v10, v2, v1,
     * v11beta2, v10beta3, v3beta1, v12alpha1, v11alpha2, foo1, foo10.
     */
    @NonNull
    Integer versionPriority;

}
