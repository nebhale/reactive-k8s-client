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

package io.k8s.events.v1;

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

/**
 * EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time. How
 * often to update the EventSeries is up to the event reporters. The default event reporter in
 * "k8s.io/client-go/tools/events/event_broadcaster.go" shows how this struct is updated on heartbeats and can guide
 * customized reporter implementations.
 */
@Builder
@Jacksonized
@Value
public class EventSeries {

    /**
     * count is the number of occurrences in this series up to the last heartbeat time.
     */
    @NonNull
    Integer count;

    @NonNull
    OffsetDateTime lastObservedTime;

}
