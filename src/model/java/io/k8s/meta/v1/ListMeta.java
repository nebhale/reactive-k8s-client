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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

/**
 * ListMeta describes metadata that synthetic resources must have, including lists and various status objects. A
 * resource may have only one of {ObjectMeta, ListMeta}.
 */
public interface ListMeta {

    /**
     * continue may be set if the user set a limit on the number of items returned, and indicates that the server has
     * more data available. The value is opaque and may be used to issue another request to the endpoint that served
     * this list to retrieve the next set of available objects. Continuing a consistent list may not be possible if the
     * server configuration has changed or more than a few minutes have passed. The resourceVersion field returned when
     * using this continue value will be identical to the value in the first response, unless you have received this
     * token from an error message.
     */
    @JsonProperty("continue")
    @Nullable
    String getContinue();

    /**
     * remainingItemCount is the number of subsequent items in the list which are not included in this list response. If
     * the list request contained label or field selectors, then the number of remaining items is unknown and the field
     * will be left unset and omitted during serialization. If the list is complete (either because it is not chunking
     * or because this is the last chunk), then there are no more remaining items and this field will be left unset and
     * omitted during serialization. Servers older than v1.15 do not set this field. The intended use of the
     * remainingItemCount is *estimating* the size of a collection. Clients should not rely on the remainingItemCount to
     * be set or to be exact.
     */
    @Nullable
    Long getRemainingItemCount();

    /**
     * String that identifies the server's internal version of this object that can be used by clients to determine when
     * objects have changed. Value must be treated as opaque by clients and passed unmodified back to the server.
     * Populated by the system. Read-only. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#concurrency-control-and-consistency
     */
    @Nullable
    String getResourceVersion();

}
