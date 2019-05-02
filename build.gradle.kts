import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.ebean:ebean-gradle-plugin:11.36.1")
    }
}

plugins {
    id("net.ltgt.apt") version "0.8" // for map struct?
    id("org.asciidoctor.convert") version "1.5.3"
    id("org.springframework.boot") version "2.1.4.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.3.21"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.21"
    id("application")
    id("org.jetbrains.kotlin.kapt") version "1.3.21"
    id("io.ebean") version "11.36.1"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

group = "com.chaoscorp.chaos"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    maven ("https://repo.spring.io/snapshot")
    maven ("https://repo.spring.io/milestone")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ebean:ebean:11.36.3")
    implementation("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    implementation("com.h2database:h2")
    implementation("org.mapstruct:mapstruct:1.3.0.Final")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    kapt("org.mapstruct:mapstruct-processor:1.3.0.Final")
}

/*
test {
	outputs.dir snippetsDir
}
*/

/*
asciidoctor {
	inputs.dir snippetsDir
	dependsOn test
}
*/
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging.showStandardStreams = true
}

ebean {
    debugLevel = 1
}

application {
    mainClassName = "com.chaoscorp.chaos.chaosServer.App"
}