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

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * A label selector is a label query over a set of resources. The result of matchLabels and matchExpressions are ANDed.
 * An empty label selector matches all objects. A null label selector matches no objects.
 */
@Builder
@Jacksonized
@Value
public class LabelSelector {

    /**
     * matchExpressions is a list of label selector requirements. The requirements are ANDed.
     */
    @Nullable
    @Singular
    List<LabelSelectorRequirement> matchExpressions;

    /**
     * matchLabels is a map of {key,value} pairs. A single {key,value} in the matchLabels map is equivalent to an
     * element of matchExpressions, whose key field is "key", the operator is "In", and the values array contains only
     * "value". The requirements are ANDed.
     */
    @Nullable
    @Singular
    Map<String, String> matchLabels;

}
