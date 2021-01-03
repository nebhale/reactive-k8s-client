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

package io.nebhale.kubernetes.generator;

import com.github.mustachejava.MustacheFactory;
import io.nebhale.kubernetes.template.Class;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@AllArgsConstructor
@ToString
public final class ClassGenerator implements Generator {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @NonNull
    private final Class _class;

    @NonNull
    private final MustacheFactory mustacheFactory;

    @Override
    public void writeTo(Path root) throws IOException {
        Path path = root.resolve(Paths.get(String.format("%s/%s.java", _class.getPackage().replaceAll("\\.", File.separator), _class.getName())));
        if (Files.exists(path)) {
            return;
        }

        logger.info("Writing {}", path);

        Files.createDirectories(path.getParent());
        try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
            mustacheFactory.compile("class.mustache").execute(writer, _class);
        }
    }

}
