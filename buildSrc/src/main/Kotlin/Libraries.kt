import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.impl(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.test(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.`kapt`(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)


val DependencyHandler.hibernateValidationLib : Dependency? get() =
    impl("org.hibernate.validator:hibernate-validator:${Versions.HibernateValidator}")

val DependencyHandler.hibernateJpaApiLib : Dependency? get() =
    impl("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:${Versions.HibernateJpaApi}")

val DependencyHandler.jacksonKotlinLib : Dependency? get() =
    impl("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.Jackson}")

val DependencyHandler.jacksonYamlLib : Dependency? get() =
    impl("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${Versions.Jackson}")

val DependencyHandler.springBootStarterActuatorLib : Dependency? get() =
    impl("org.springframework.boot:spring-boot-starter-actuator:${Versions.SpringBoot}")

val DependencyHandler.springBootStarterWebLib : Dependency? get() =
    impl("org.springframework.boot:spring-boot-starter-web:${Versions.SpringBoot}")

val DependencyHandler.springBootStarterAOPLib : Dependency? get() =
    impl("org.springframework.boot:spring-boot-starter-aop:${Versions.SpringBoot}")

val DependencyHandler.kotlinReflectLib : Dependency? get() =
    impl("org.jetbrains.kotlin:kotlin-reflect")

val DependencyHandler.kotlinJdk8Lib : Dependency? get() =
    impl("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

val DependencyHandler.ebeanLib : Dependency? get() =
    impl("io.ebean:ebean:${Versions.Ebean}")

val DependencyHandler.ebeanTestConfigLib : Dependency? get() =
    test("io.ebean.test:ebean-test-config:${Versions.Ebean}")

val DependencyHandler.ebeanQueryLib : Dependency? get() =
    impl("io.ebean:ebean-querybean:${Versions.Ebean}")

val DependencyHandler.ebeanQueryGeneratorKaptLib : Dependency? get() =
    kapt("io.ebean:kotlin-querybean-generator:${Versions.Ebean}")

val DependencyHandler.h2DataBaseLib : Dependency? get() =
    impl("com.h2database:h2")

val DependencyHandler.mapstructLib : Dependency? get() =
    impl("org.mapstruct:mapstruct:${Versions.MapStruct}")

val DependencyHandler.springBootStarterTestLib : Dependency? get() =
    test("org.springframework.boot:spring-boot-starter-test")

val DependencyHandler.springRestDocsMockMvcTestLib : Dependency? get() =
    test("org.springframework.restdocs:spring-restdocs-mockmvc")

val DependencyHandler.mapstrucProcessorKaptLib : Dependency? get() =
    kapt("org.mapstruct:mapstruct-processor:${Versions.MapStruct}")

val DependencyHandler.feignJacksonLib : Dependency? get() =
    impl("io.github.openfeign:feign-jackson:${Versions.FeignJackson}")

val DependencyHandler.googleApiClient : Dependency? get() =
    impl("com.google.api-client:google-api-client:${Versions.GoogleApiClient}")

val DependencyHandler.karateApachTestLib : Dependency? get() =
    test("com.intuit.karate:karate-apache:${Versions.Karate}")

val DependencyHandler.karateJunitTestLib : Dependency? get() =
    test("com.intuit.karate:karate-junit4:${Versions.Karate}")