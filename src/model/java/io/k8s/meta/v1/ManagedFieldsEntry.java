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

import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.Nullable;

/**
 * ManagedFieldsEntry is a workflow-id, a FieldSet and the group version of the resource that the fieldset applies to.
 */
@Builder
@Jacksonized
@Value
public class ManagedFieldsEntry {

    /**
     * APIVersion defines the version of this resource that this field set applies to. The format is "group/version"
     * just like the top-level APIVersion field. It is necessary to track the version of a field set because it cannot
     * be automatically converted.
     */
    @Nullable
    String apiVersion;

    /**
     * FieldsType is the discriminator for the different fields format and version. There is currently only one possible
     * value: "FieldsV1"
     */
    @Nullable
    String fieldsType;

    @Nullable
    FieldsV1 fieldsV1;

    /**
     * Manager is an identifier of the workflow managing these fields.
     */
    @Nullable
    String manager;

    /**
     * Operation is the type of operation which lead to this ManagedFieldsEntry being created. The only valid values for
     * this field are 'Apply' and 'Update'.
     */
    @Nullable
    String operation;

    @Nullable
    OffsetDateTime time;

}
