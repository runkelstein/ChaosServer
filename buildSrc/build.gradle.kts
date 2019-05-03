repositories {
    mavenCentral()
    jcenter()
}

plugins {
    `kotlin-dsl`
}

dependencies {
    runtimeClasspath("io.ebean:ebean-gradle-plugin:11.37.1")
}