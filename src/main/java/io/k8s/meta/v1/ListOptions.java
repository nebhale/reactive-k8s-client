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

package io.k8s.meta.v1;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ListOptions is the query options to a standard REST list call.
 */
@Builder
@Jacksonized
@Value
public class ListOptions implements TypeMeta {

    @Nullable
    String kind;

    @Nullable
    String apiVersion;

    /**
     * A selector to restrict the list of returned objects by their labels. Defaults to everything.
     */
    @Nullable
    String labelSelector;

    /**
     * A selector to restrict the list of returned objects by their fields. Defaults to everything.
     */
    @Nullable
    String fieldSelector;

    /**
     * Watch for changes to the described resources and return them as a stream of add, update, and remove
     * notifications. Specify resourceVersion.
     */
    @Nullable
    Boolean watch;

    /**
     * allowWatchBookmarks requests watch events with type "BOOKMARK". Servers that do not implement bookmarks may
     * ignore this flag and bookmarks are sent at the server's discretion. Clients should not assume bookmarks are
     * returned at any specific interval, nor may they assume the server will send any BOOKMARK event during a session.
     * If this is not a watch, this field is ignored.
     */
    @Nullable
    Boolean allowWatchBookmarks;

    /**
     * resourceVersion sets a constraint on what resource versions a request may be served from. See
     * https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details. Defaults to unset
     */
    @Nullable
    String resourceVersion;

    /**
     * resourceVersionMatch determines how resourceVersion is applied to list calls. It is highly recommended that
     * resourceVersionMatch be set for list calls where resourceVersion is set See
     * https://kubernetes.io/docs/reference/using-api/api-concepts/#resource-versions for details. Defaults to unset
     */
    @Nullable
    String resourceVersionMatch;

    /**
     * Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
     */
    @Nullable
    Long timeoutSeconds;

    /**
     * limit is a maximum number of responses to return for a list call. If more items exist, the server will set the
     * `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the
     * next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in
     * the event all requested objects are filtered out and clients should only use the presence of the continue field
     * to determine whether more results are available. Servers may choose not to support the limit argument and will
     * return all of the available results. If limit is specified and the continue field is empty, clients may assume
     * that no more results are available. This field is not supported if watch is true. The server guarantees that the
     * objects returned when using continue will be identical to issuing a single list call without a limit - that is,
     * no objects created, modified, or deleted after the first request is issued will be included in any subsequent
     * continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is
     * using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects
     * are updated during a chunked list the version of the object that was present at the time the first list result
     * was calculated is returned.
     */
    Long limit;

    /**
     * The continue option should be set when retrieving more results from the server. Since this value is server
     * defined, clients may only use the continue value from a previous query result with identical query parameters
     * (except for the value of continue) and the server may reject a continue value it does not recognize. If the
     * specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a
     * configuration change on the server, the server will respond with a 410 ResourceExpired error together with a
     * continue token. If the client needs a consistent list, it must restart their list without the continue field.
     * Otherwise, the client may send another list request with the token received with the 410 error, the server will
     * respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the
     * previous list results - objects that are created, modified, or deleted after the first list request will be
     * included in the response, as long as their keys are after the "next key". This field is not supported when watch
     * is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any
     * modifications.
     */
    String _continue;

}
