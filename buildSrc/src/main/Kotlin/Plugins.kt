import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

// todo: inline warning, issue with gradle and intelijii

val ebeanPluginId = "io.ebean"
val mavenPublishPluginId = "maven-publish"
val asciiDoctorPluginId = "org.asciidoctor.convert"
val springBootPluginId = "org.springframework.boot"
val springDependencyPluginId = "io.spring.dependency-management"
val kotlinSpringPluginId = "org.jetbrains.kotlin.plugin.spring"
val kotlinJvmPluginId = "org.jetbrains.kotlin.jvm"
val kotlinKaptPluginId = "org.jetbrains.kotlin.kapt"

val PluginDependenciesSpec.ebeanPlugin: PluginDependencySpec
    get() = id(ebeanPluginId)

val PluginDependenciesSpec.mavenPublishPlugin: PluginDependencySpec
    get() = id(mavenPublishPluginId)

val PluginDependenciesSpec.asciiDoctorPlugin: PluginDependencySpec
    get() = id(asciiDoctorPluginId).version(Versions.AsciiDoctor)

val PluginDependenciesSpec.springBootPlugin: PluginDependencySpec
    get() = id(springBootPluginId).version(Versions.SpringBoot)

val PluginDependenciesSpec.springDependencyPlugin: PluginDependencySpec
    get() = id(springDependencyPluginId).version(Versions.SpringDependencyManagement)

val PluginDependenciesSpec.kotlinSpringPlugin: PluginDependencySpec
    get() = id(kotlinSpringPluginId).version(Versions.Kotlin)

val PluginDependenciesSpec.kotlinJvmPlugin: PluginDependencySpec
    get() = id(kotlinJvmPluginId).version(Versions.Kotlin)

val PluginDependenciesSpec.kotlinKaptPlugin: PluginDependencySpec
    get() = id(kotlinKaptPluginId).version(Versions.Kotlin)

