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

package io.k8s.authorization.v1;

import io.k8s.meta.v1.ManagedFieldsEntry;
import io.k8s.meta.v1.ObjectMeta;
import io.k8s.meta.v1.OwnerReference;
import io.k8s.meta.v1.TypeMeta;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * SelfSubjectRulesReview enumerates the set of actions the current user can perform within a namespace. The returned
 * list of actions may be incomplete depending on the server's authorization mode, and any errors experienced during the
 * evaluation. SelfSubjectRulesReview should be used by UIs to show/hide actions, or to quickly let an end user reason
 * about their permissions. It should NOT Be used by external systems to drive authorization decisions as this raises
 * confused deputy, cache lifetime/revocation, and correctness concerns. SubjectAccessReview, and LocalAccessReview are
 * the correct way to defer authorization decisions to the API server.
 */
@Builder
@Jacksonized
@Value
public class SelfSubjectRulesReview implements ObjectMeta, TypeMeta {

    public static final String GROUP = "authorization.k8s.io";

    public static final String KIND = "SelfSubjectRulesReview";

    public static final String VERSION = "v1";

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized
     * schemas to the latest internal value, and may reject unrecognized values. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @Nullable
    String apiVersion;

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the
     * endpoint the client submits requests to. Cannot be updated. In CamelCase. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @Nullable
    String kind;

    @NonNull
    SelfSubjectRulesReviewSpec spec;

    @Nullable
    SubjectRulesReviewStatus status;

    /**
     * Annotations is an unstructured key value map stored with a resource that may be set by external tools to store
     * and retrieve arbitrary metadata. They are not queryable and should be preserved when modifying objects. More
     * info: http://kubernetes.io/docs/user-guide/annotations
     */
    @Nullable
    @Singular
    Map<String, String> annotations;

    /**
     * The name of the cluster which the object belongs to. This is used to distinguish resources with same name and
     * namespace in different clusters. This field is not set anywhere right now and apiserver is going to ignore it if
     * set in create or update request.
     */
    @Nullable
    String clusterName;

    @Nullable
    OffsetDateTime creationTimestamp;

    /**
     * Number of seconds allowed for this object to gracefully terminate before it will be removed from the system. Only
     * set when deletionTimestamp is also set. May only be shortened. Read-only.
     */
    @Nullable
    Long deletionGracePeriodSeconds;

    @Nullable
    OffsetDateTime deletionTimestamp;

    /**
     * Must be empty before the object is deleted from the registry. Each entry is an identifier for the responsible
     * component that will remove the entry from the list. If the deletionTimestamp of the object is non-nil, entries in
     * this list can only be removed. Finalizers may be processed and removed in any order.  Order is NOT enforced
     * because it introduces significant risk of stuck finalizers. finalizers is a shared field, any actor with
     * permission can reorder it. If the finalizer list is processed in order, then this can lead to a situation in
     * which the component responsible for the first finalizer in the list is waiting for a signal (field value,
     * external system, or other) produced by a component responsible for a finalizer later in the list, resulting in a
     * deadlock. Without enforced ordering finalizers are free to order amongst themselves and are not vulnerable to
     * ordering changes in the list.
     */
    @Nullable
    @Singular
    List<String> finalizers;

    /**
     * GenerateName is an optional prefix, used by the server, to generate a unique name ONLY IF the Name field has not
     * been provided. If this field is used, the name returned to the client will be different than the name passed.
     * This value will also be combined with a unique suffix. The provided value has the same validation rules as the
     * Name field, and may be truncated by the length of the suffix required to make the value unique on the server.
     * 
     * If
     * this field is specified and the generated name exists, the server will NOT return a 409 - instead, it will either
     * return 201 Created or 500 with Reason ServerTimeout indicating a unique name could not be found in the time
     * allotted, and the client should retry (optionally after the time indicated in the Retry-After header).
     * 
     * Applied
     * only if Name is not specified. More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#idempotency
     */
    @Nullable
    String generateName;

    /**
     * A sequence number representing a specific generation of the desired state. Populated by the system. Read-only.
     */
    @Nullable
    Long generation;

    /**
     * Map of string keys and values that can be used to organize and categorize (scope and select) objects. May match
     * selectors of replication controllers and services. More info: http://kubernetes.io/docs/user-guide/labels
     */
    @Nullable
    @Singular
    Map<String, String> labels;

    /**
     * ManagedFields maps workflow-id and version to the set of fields that are managed by that workflow. This is mostly
     * for internal housekeeping, and users typically shouldn't need to set or understand this field. A workflow can be
     * the user's name, a controller's name, or the name of a specific apply path like "ci-cd". The set of fields is
     * always in the version that the workflow used when modifying the object.
     */
    @Nullable
    @Singular
    List<ManagedFieldsEntry> managedFields;

    /**
     * Name must be unique within a namespace. Is required when creating resources, although some resources may allow a
     * client to request the generation of an appropriate name automatically. Name is primarily intended for creation
     * idempotence and configuration definition. Cannot be updated. More info:
     * http://kubernetes.io/docs/user-guide/identifiers#names
     */
    @Nullable
    String name;

    /**
     * Namespace defines the space within which each name must be unique. An empty namespace is equivalent to the
     * "default" namespace, but "default" is the canonical representation. Not all objects are required to be scoped to
     * a namespace - the value of this field for those objects will be empty.
     * 
     * Must be a DNS_LABEL. Cannot be updated.
     * More info: http://kubernetes.io/docs/user-guide/namespaces
     */
    @Nullable
    String namespace;

    /**
     * List of objects depended by this object. If ALL objects in the list have been deleted, this object will be
     * garbage collected. If this object is managed by a controller, then an entry in this list will point to this
     * controller, with the controller field set to true. There cannot be more than one managing controller.
     */
    @Nullable
    @Singular
    List<OwnerReference> ownerReferences;

    /**
     * An opaque value that represents the internal version of this object that can be used by clients to determine when
     * objects have changed. May be used for optimistic concurrency, change detection, and the watch operation on a
     * resource or set of resources. Clients must treat these values as opaque and passed unmodified back to the server.
     * They may only be valid for a particular resource or set of resources.
     * 
     * Populated by the system. Read-only. Value
     * must be treated as opaque by clients and . More info:
     * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#concurrency-control-and-consistency
     */
    @Nullable
    String resourceVersion;

    /**
     * UID is the unique in time and space value for this object. It is typically generated by the server on successful
     * creation of a resource and is not allowed to change on PUT operations.
     * 
     * Populated by the system. Read-only. More
     * info: http://kubernetes.io/docs/user-guide/identifiers#uids
     */
    @Nullable
    String uid;

}
