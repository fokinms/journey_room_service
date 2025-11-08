import com.google.protobuf.gradle.id

plugins {
    java
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.hibernate.orm") version "6.6.29.Final"
    id("com.google.protobuf") version "0.9.4"
}
val springGrpcVersion by extra("0.11.0")

group = "org.fokinms.journey"
version = "0.0.1-SNAPSHOT"
description = "room_service"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    /**
     * Spring boot starters
     */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.grpc:spring-grpc-spring-boot-starter")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    /**
     * Database
     */
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")

    /**
     * Environment
     */
    implementation("me.paulschwarz:spring-dotenv:4.0.0")

    /**
     * Utils
     */
    implementation("io.grpc:grpc-services")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

    /**
     * Tests
     */
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.grpc:spring-grpc-test")
}
dependencyManagement {
    imports {
        mavenBom("org.springframework.grpc:spring-grpc-dependencies:$springGrpcVersion")
    }
}

hibernate {
    enhancement {
        enableAssociationManagement = true
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.1"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.76.0"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
