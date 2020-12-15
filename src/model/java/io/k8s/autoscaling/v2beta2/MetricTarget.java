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

package io.k8s.autoscaling.v2beta2;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * MetricTarget defines the target value, average value, or average utilization of a specific metric
 */
@Builder
@Jacksonized
@Value
public class MetricTarget {

    /**
     * averageUtilization is the target value of the average of the resource metric across all relevant pods,
     * represented as a percentage of the requested value of the resource for the pods. Currently only valid for
     * Resource metric source type
     */
    @Nullable
    Integer averageUtilization;

    @Nullable
    String averageValue;

    /**
     * type represents whether the metric type is Utilization, Value, or AverageValue
     */
    @NonNull
    String type;

    @Nullable
    String value;

}
