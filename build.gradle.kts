import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = Properties.groupId
version = Properties.versionId

plugins {
    kotlinJvmPlugin
    kotlinSpringPlugin
    kotlinKaptPlugin
    springBootPlugin apply false
    springDependencyPlugin
    asciiDoctorPlugin
    ebeanPlugin
    mavenPublishPlugin
    application
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
        plugin(kotlinJvmPluginId)
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        hibernateValidationLib
        jacksonKotlinLib
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
        plugin(kotlinSpringPluginId)
        plugin(springBootPluginId)
        plugin(kotlinKaptPluginId)
        plugin(ebeanPluginId)
        
        plugin(springDependencyPluginId)
        plugin("application")
    }

    dependencies {
        // implementation
        springBootStarterActuatorLib
        springBootStarterWebLib
        springBootStarterAOPLib
        kotlinReflectLib
        kotlinJdk8Lib
        ebeanLib
        ebeanQueryLib
        hibernateJpaApiLib
        h2DataBaseLib
        mySQLConnectorLib
        mapstructLib
        mapstrucProcessorKaptLib
        ebeanQueryGeneratorKaptLib
        jacksonYamlLib
        googleApiClient

        // testing
        springBootStarterTestLib
        springRestDocsMockMvcTestLib
        karateApachTestLib
        karateJunitTestLib
        ebeanTestConfigLib

        // projects
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
        mainClassName = "${Properties.groupId}.App"
        applicationDefaultJvmArgs = listOf("-Dspring.profiles.active=dev")
    }

}

allprojects {

    val publishModules = setOf("api", "client")
    val moduleName =name

    if (moduleName in publishModules) {

        apply {
            plugin(mavenPublishPluginId)
        }

        publishing {
            publications {
                create<MavenPublication>("maven") {
                    groupId = Properties.groupId
                    artifactId = Properties.getFullArtifactId(moduleName)
                    version = Properties.versionId

                    from(components["java"])
                }
            }

            repositories {
                maven {
                    url = uri("https://chaoscorp.org:743")
                    // credentials need to be put into the USER_HOME/.gradle/gradle.properties file
                    // because of security concerns they can not be stored in the scm
                    credentials {
                        username = System.getProperty("chaosMavenUser")
                        password = System.getProperty("chaosMavenPassword")
                    }
                }
            }

        }
    }

}

project(":client") {

    dependencies {
        feignOkHttpLib
        feignJacksonLib
        implementation(project(":api"))
    }

}
