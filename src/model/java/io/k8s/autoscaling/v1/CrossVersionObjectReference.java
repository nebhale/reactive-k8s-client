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

package io.k8s.autoscaling.v1;

import io.k8s.meta.v1.TypeMeta;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * CrossVersionObjectReference contains enough information to let you identify the referred resource.
 */
@Builder
@Jacksonized
@Value
public class CrossVersionObjectReference implements TypeMeta {

    /**
     * API version of the referent
     */
    @Nullable
    String apiVersion;

    /**
     * Kind of the referent; More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds"
     */
    @NonNull
    String kind;

    /**
     * Name of the referent; More info: http://kubernetes.io/docs/user-guide/identifiers#names
     */
    @NonNull
    String name;

}
