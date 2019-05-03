import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.chaoscorp.chaos"
version = "0.0.1-SNAPSHOT"

plugins {
    id("org.asciidoctor.convert") version "1.5.3"
    id("org.springframework.boot") version "2.1.4.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.3.21"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.21"
    id("application")
    id("org.jetbrains.kotlin.kapt") version "1.3.21"
    id("io.ebean")
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    `build-scan`
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
    publishAlways()
}


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

allprojects {

    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.hibernate.validator:hibernate-validator:6.0.16.Final")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.7")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

}

project(":server") {

    apply {
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("org.jetbrains.kotlin.kapt")
        plugin("io.ebean")
        plugin("io.spring.dependency-management")
        plugin("application")
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("io.ebean:ebean:11.37.1")
        implementation("io.ebean:ebean-querybean:11.37.1")
        implementation("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
        implementation("com.h2database:h2")
        implementation("org.mapstruct:mapstruct:1.3.0.Final")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
        kapt("org.mapstruct:mapstruct-processor:1.3.0.Final")
        kapt("io.ebean:kotlin-querybean-generator:11.37.1")
        implementation(project(":api"))
    }


    tasks.withType<Test> {
        //useJUnitPlatform()
        testLogging.showStandardStreams = true
    }

    ebean {
        debugLevel = 1
    }

    application {
        mainClassName = "com.chaoscorp.chaosServer.App"
    }

}

project(":api") {



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

