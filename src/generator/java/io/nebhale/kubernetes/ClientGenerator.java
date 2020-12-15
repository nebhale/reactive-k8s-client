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

package io.nebhale.kubernetes;

import com.github.mustachejava.MustacheFactory;
import io.k8s.meta.v1.CreateOptions;
import io.k8s.meta.v1.GetOptions;
import io.k8s.meta.v1.ListOptions;
import io.k8s.meta.v1.PatchOptions;
import io.k8s.meta.v1.UpdateOptions;
import io.k8s.type.PatchType;
import io.nebhale.kubernetes.generator.CompositeGenerator;
import io.nebhale.kubernetes.generator.Generator;
import io.nebhale.kubernetes.generator.InterfaceGenerator;
import io.nebhale.kubernetes.generator.PackageGenerator;
import io.nebhale.kubernetes.template.DefaultType;
import io.nebhale.kubernetes.template.Interface;
import io.nebhale.kubernetes.template.MethodSignature;
import io.nebhale.kubernetes.template.MonoType;
import io.nebhale.kubernetes.template.NeverImportType;
import io.nebhale.kubernetes.template.Parameter;
import io.nebhale.kubernetes.template.Type;
import io.nebhale.kubernetes.template.VariableArgumentsType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Component
@Order(2)
final class ClientGenerator implements CommandLineRunner {

    private static final String ACTION = "x-kubernetes-action";

    private static final String GROUP_VERSION_KIND = "x-kubernetes-group-version-kind";

    private static final String SUB_RESOURCE = "x-kubernetes-subresource";

    private static final String MEDIA_TYPE_ALL = "*/*";

    private static final String MEDIA_TYPE_APPLICATION_JSON = "application/json";

    private static final String MEDIA_TYPE_APPLICATION_JSON_PATCH_JSON = "application/json-patch+json";

    private static final Pattern URI_PATTERN = Pattern.compile("^/api(?:s/[^/]+)?/[^/]+(?:/watch)?(?:/namespaces/[^/]+)?/[^/]+(?:/[^/]+(?:/(?<subresource>[^/]+(?:/[^/]+)?))?)?$");

    private static final List<String> CREATE_OPTIONS_PARAMETERS = Arrays.asList(
        "kind",
        "apiVersion",
        "dryRun",
        "fieldManager"
    );

    private static final List<String> DELETE_OPTIONS_PARAMETERS = Arrays.asList(
        "apiVersion",
        "dryRun",
        "gracePeriodSeconds",
        "kind",
        "orphanDependents",
        "preconditions",
        "propagationPolicy"
    );

    private static final List<String> GET_OPTIONS_PARAMETERS = Arrays.asList(
        "kind",
        "apiVersion",
        "resourceVersion"
    );

    private static final List<String> LIST_OPTIONS_PARAMETERS = Arrays.asList(
        "kind",
        "apiVersion",
        "labelSelector",
        "fieldSelector",
        "watch",
        "allowWatchBookmarks",
        "resourceVersion",
        "resourceVersionMatch",
        "timeoutSeconds",
        "limit",
        "continue"
    );

    private static final List<String> PATCH_OPTIONS_PARAMETERS = Arrays.asList(
        "kind",
        "apiVersion",
        "dryRun",
        "force",
        "fieldManager"
    );

    private static final List<String> UPDATE_OPTIONS_PARAMETERS = Arrays.asList(
        "kind",
        "apiVersion",
        "dryRun",
        "fieldManager"
    );

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @NonNull
    @Value("${client}")
    private final Path path;

    @NonNull
    private final MustacheFactory mustacheFactory;

    @NonNull
    private final OpenAPI openAPI;

    @NonNull
    private final TypeFactory typeFactory;

    @Override
    public void run(String... args) throws IOException {
        Map<GroupVersionKind, List<Operation>> clients = Util.getSafePaths(openAPI).entrySet().stream()
            .filter(e -> !Util.isDeprecated(e.getValue().getDescription()))
            .flatMap(e -> e.getValue().readOperations().stream()
                .filter(o -> Util.getSafeExtensions(o).containsKey(GROUP_VERSION_KIND) && !Util.isDeprecated(o.getDescription()))
                .map(o -> withAdditionalParameters(o, Util.getSafeParameters(e.getValue())))
                .map(o -> withSubresource(o, e.getKey())))
            .collect(Collectors.groupingBy(this::getGroupVersionKind));

        List<Generator> generators = clients.entrySet().stream()
            .map(e -> getGenerator(e.getKey(), e.getValue()))
            .collect(Collectors.toList());

        if (FileSystemUtils.deleteRecursively(path)) {
            logger.warn("Deleted {}", path);
        }

        for (Generator g : generators) {
            g.writeTo(path);
        }
    }

    private Action getAction(Operation operation) {
        return Action.valueOf(((String) Util.getSafeExtensions(operation).get(ACTION)).toUpperCase());
    }

    @Nullable
    private Type getRequestBodyType(Operation operation) {
        RequestBody requestBody = operation.getRequestBody();
        if (requestBody == null) {
            return null;
        }

        Content content = requestBody.getContent();
        if (content == null) {
            return null;
        }

        MediaType mediaType = content.get(MEDIA_TYPE_ALL);
        if (mediaType == null) {
            mediaType = content.get(MEDIA_TYPE_APPLICATION_JSON_PATCH_JSON);
        }
        if (mediaType == null) {
            logger.warn("{} missing {}} request body type", operation.getOperationId(), MEDIA_TYPE_ALL);
            return null;
        }

        Schema<?> schema = mediaType.getSchema();
        if (schema == null) {
            return null;
        }

        return typeFactory.create(schema);
    }

    private Generator getGenerator(GroupVersionKind gvk, List<Operation> operations) {
        Type type = getType(gvk.getKind(), operations.get(0));

        Generator packageGenerator = new PackageGenerator(type.getPackage(), mustacheFactory);

        List<MethodSignature> methodSignatures = operations.stream()
            .map(this::getMethodSignature)
            .distinct()
            .sorted()
            .collect(Collectors.toList());

        Interface _interface = new Interface(null, type, methodSignatures);

        return new CompositeGenerator(packageGenerator, new InterfaceGenerator(_interface, mustacheFactory));
    }

    @SuppressWarnings("unchecked")
    private GroupVersionKind getGroupVersionKind(Operation operation) {
        Map<String, String> raw = (Map<String, String>) Util.getSafeExtensions(operation).get(GROUP_VERSION_KIND);
        return new GroupVersionKind(raw.get("group"), raw.get("version"), raw.get("kind"));
    }

    private MethodSignature getMethodSignature(Operation operation) {
        Action action = getAction(operation);

        String methodName = action.getMethodName();
        String subresource = (String) Util.getSafeExtensions(operation).get(SUB_RESOURCE);
        if (subresource != null) {
            methodName = String.format("%s%s", methodName, StringUtils.capitalize(subresource));
        }

        return new MethodSignature(operation.getDescription(), Collections.emptySet(), getReturnType(operation),
            methodName, getParameters(action, operation));
    }

    private List<Parameter> getParameters(Action action, Operation operation) {
        List<Parameter> parameters = Util.getSafeParameters(operation).stream()
            .filter(p -> isInterestingParameter(action, p))
            .map(p -> new Parameter(typeFactory.create(p.getSchema()), p.getName()))
            .collect(Collectors.toList());

        if (action == Action.PATCH) {
            parameters.add(new Parameter(new DefaultType(PatchType.class), "type"));
        }

        Type requestBodyType = getRequestBodyType(operation);
        if (requestBodyType != null) {
            parameters.add(new Parameter(requestBodyType, "body"));
        }

        if (action == Action.DELETECOLLECTION) {
            parameters.add(new Parameter(new DefaultType(ListOptions.class), "options"));
        }

        if (action == Action.GET) {
            parameters.add(new Parameter(new DefaultType(GetOptions.class), "options"));
        }

        if (action == Action.LIST || action == Action.WATCH || action == Action.WATCHLIST) {
            parameters.add(new Parameter(new DefaultType(ListOptions.class), "options"));
        }

        if (action == Action.PATCH) {
            parameters.add(new Parameter(new DefaultType(PatchOptions.class), "options"));
            parameters.add(new Parameter(new VariableArgumentsType(new NeverImportType(new DefaultType(String.class))), "subresources"));
        }

        if (action == Action.POST) {
            parameters.add(new Parameter(new DefaultType(CreateOptions.class), "options"));
        }

        if (action == Action.PUT) {
            parameters.add(new Parameter(new DefaultType(UpdateOptions.class), "options"));
        }

        return parameters;
    }

    private Type getReturnType(Operation operation) {
        ApiResponse response = Util.getSafeResponses(operation).get("200");
        if (response == null) {
            logger.warn("{} missing 200 response", operation.getOperationId());
            return MonoType.MONO_VOID;
        }

        MediaType mediaType = response.getContent().get(MEDIA_TYPE_APPLICATION_JSON);
        if (mediaType == null) {
            return MonoType.MONO_VOID;
        }

        Schema<?> schema = mediaType.getSchema();
        if (schema == null) {
            return MonoType.MONO_VOID;
        }

        return new MonoType(typeFactory.create(schema));
    }

    private Type getType(String kind, Operation operation) {
        String _package = Util.getSafeTags(operation).stream()
            .flatMap(s -> Arrays.stream(s.split("_")))
            .collect(Collectors.joining("."));

        return new DefaultType(String.format("io.nebhale.kubernetes.client.%s.%sClient", _package, kind));
    }

    private boolean isInterestingParameter(Action action, io.swagger.v3.oas.models.parameters.Parameter parameter) {
        String name = parameter.getName();

        if ("pretty".equals(name)) {
            return false;
        }

        if ("namespace".equals(name)) {
            return false;
        }

        if (Util.isDeprecated(parameter.getDescription())) {
            return false;
        }

        if (action == Action.DELETE && DELETE_OPTIONS_PARAMETERS.contains(name)) {
            return false;
        }

        if (action == Action.DELETECOLLECTION &&
            (DELETE_OPTIONS_PARAMETERS.contains(name) || LIST_OPTIONS_PARAMETERS.contains(name))
        ) {
            return false;
        }

        if (action == Action.GET && GET_OPTIONS_PARAMETERS.contains(name)) {
            return false;
        }

        if ((action == Action.LIST || action == Action.WATCH || action == Action.WATCHLIST) &&
            LIST_OPTIONS_PARAMETERS.contains(name)
        ) {
            return false;
        }

        if (action == Action.PATCH && PATCH_OPTIONS_PARAMETERS.contains(name)) {
            return false;
        }

        if (action == Action.POST && CREATE_OPTIONS_PARAMETERS.contains(name)) {
            return false;
        }

        if (action == Action.PUT && UPDATE_OPTIONS_PARAMETERS.contains(name)) {
            return false;
        }

        return true;
    }

    private Operation withAdditionalParameters(Operation operation, List<io.swagger.v3.oas.models.parameters.Parameter> parameters) {
        List<io.swagger.v3.oas.models.parameters.Parameter> p = Stream.concat(Util.getSafeParameters(operation).stream(), parameters.stream())
            .collect(Collectors.toList());

        operation.setParameters(p);
        return operation;
    }

    private Operation withSubresource(Operation operation, String uri) {
        Matcher matcher = URI_PATTERN.matcher(uri);
        if (matcher.find()) {
            Map<String, Object> extensions = Util.getSafeExtensions(operation);
            extensions.put(SUB_RESOURCE, matcher.group("subresource"));
            operation.setExtensions(extensions);
        }
        return operation;
    }

    private enum Action {

        CONNECT("connect"),
        POST("create"),
        DELETE("delete"),
        DELETECOLLECTION("deleteCollection"),
        GET("get"),
        LIST("list"),
        PATCH("patch"),
        PUT("update"),
        WATCH("watch"),
        WATCHLIST("watchList");

        private final String methodName;

        Action(String methodName) {
            this.methodName = methodName;
        }

        public String getMethodName() {
            return methodName;
        }

    }

    @lombok.Value
    private static class GroupVersionKind {

        @NonNull
        String group;

        @NonNull
        String version;

        @NonNull
        String kind;

    }

}
