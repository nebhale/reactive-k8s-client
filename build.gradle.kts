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

plugins {
    `java-library`
    id("io.freefair.lombok") version "5.3.0"
}

sourceSets {
    create("generator") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }

    create("model") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }

    create("client") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
        compileClasspath += sourceSets["model"].output
        runtimeClasspath += sourceSets["model"].output
    }
}

val generatorImplementation by configurations.getting { extendsFrom(configurations.implementation.get()) }
val modelImplementation by configurations.getting { extendsFrom(configurations.implementation.get()) }
val clientImplementation by configurations.getting { extendsFrom(configurations.implementation.get()) }

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.4.0"))
    api("com.fasterxml.jackson.core:jackson-databind")
    api("io.projectreactor:reactor-core")
    implementation("org.springframework:spring-core")

    generatorImplementation("com.github.spullara.mustache.java:compiler:0.9.7")
    generatorImplementation("io.swagger.parser.v3:swagger-parser:2.0.23")
    generatorImplementation("org.apache.commons:commons-text:1.9")
    generatorImplementation("org.springframework.boot:spring-boot-starter")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

repositories {
    mavenCentral()
}

tasks.withType<Jar> {
    from(sourceSets["model"].output)
    from(sourceSets["client"].output)
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<io.freefair.gradle.plugins.lombok.tasks.GenerateLombokConfig> {
    enabled = false
}
