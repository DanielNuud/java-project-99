import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
	application
	java
	jacoco
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
	id("io.freefair.lombok") version "8.4"
	checkstyle
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

application {
	mainClass.set("hexlet.code.AppApplication")
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("net.datafaker:datafaker:2.0.1")
	implementation("org.instancio:instancio-junit:3.3.0")
	implementation("org.mapstruct:mapstruct:1.5.5.Final")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

	testImplementation("org.springframework.security:spring-security-test")
	testImplementation(platform("org.junit:junit-bom:5.10.0"))
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("net.javacrumbs.json-unit:json-unit-assertj:3.2.2")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql:42.6.0")
}

tasks.test {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}


tasks.jacocoTestReport {
	reports {
		xml.required = true
	}
}

jacoco {
	toolVersion = "0.8.11"
	reportsDirectory = layout.buildDirectory.dir("reports/jacoco")
}
