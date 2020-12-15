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

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * FieldsV1 stores a set of fields in a data structure like a Trie, in JSON format.
 * 
 * Each key is either a '.'
 * representing the field itself, and will always map to an empty set, or a string representing a sub-field or item. The
 * string will follow one of these four formats: 'f:<name>', where <name> is the name of a field in a struct, or key in
 * a map 'v:<value>', where <value> is the exact json formatted value of a list item 'i:<index>', where <index> is
 * position of a item in a list 'k:<keys>', where <keys> is a map of  a list item's key fields to their unique values If
 * a key maps to an empty Fields value, the field that key represents is part of the set.
 * 
 * The exact format is defined
 * in sigs.k8s.io/structured-merge-diff
 */
@Builder
@Jacksonized
@Value
public class FieldsV1 {

}
