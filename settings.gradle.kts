import java.util.Properties

dependencyResolutionManagement {
    versionCatalogs {
        val kotlinVersion = "1.9.10"
        create("libs") {
            version("kotlin", kotlinVersion)

            version("android-build-tools", "8.1.2")
            version("jvm", "17")

            plugin("android-library", "com.android.library").versionRef("android-build-tools")
            plugin("multiplatform", "org.jetbrains.kotlin.multiplatform").versionRef("kotlin")
            plugin("cocoapods", "org.jetbrains.kotlin.native.cocoapods").versionRef("kotlin")

            library("android-build-tools", "com.android.tools.build", "gradle").versionRef("android-build-tools")
            library("gradle-plugin", "org.jetbrains.kotlin", "kotlin-gradle-plugin").versionRef("kotlin")
        }
        create("testingLibs") {
            version("kotlin", kotlinVersion)
            version("kotest", "5.6.2")

            library("detekt", "io.gitlab.arturbosch.detekt", "detekt-gradle-plugin").version("1.23.0")
            library("detekt-formatting", "io.gitlab.arturbosch.detekt", "detekt-formatting").version("1.23.0")
            library("kotest-plugin", "io.kotest", "kotest-framework-multiplatform-plugin-gradle").versionRef("kotest")
            plugin("kover", "org.jetbrains.kotlinx.kover").version("0.6.1")

            library("test-junit", "org.jetbrains.kotlin","kotlin-test-junit").withoutVersion()
            library("junit", "junit", "junit").version("4.13.2")
            library("kotest-core", "io.kotest", "kotest-assertions-core").versionRef("kotest")
            library("kotest-engine", "io.kotest", "kotest-framework-engine").versionRef("kotest")
            library("turbine", "app.cash.turbine", "turbine").version("1.0.0")
            library("test-annotations-common", "org.jetbrains.kotlin", "kotlin-test-annotations-common").withoutVersion()
            library("test-common", "org.jetbrains.kotlin", "kotlin-test-common").versionRef("kotlin")
            library("robolectric", "org.robolectric", "robolectric").version("4.8")
        }

        // Android is a reserved keyword
        create("androidVersions") {
            version("compileSdk", "34")
            version("buildToolsVersion", "33.0.1")
            version("minSdk", "28")
            version("targetSdk", "34")
        }
    }
}

include(":library")

val properties = Properties()
val propertiesFile = File("library/gradle.properties")
if (propertiesFile.exists()) {
    properties.load(propertiesFile.inputStream())
}
val PUBLISH_NAME = properties.getProperty("PUBLISH_NAME")

rootProject.name = PUBLISH_NAME
rootProject.children.forEach {
    it.name = PUBLISH_NAME
}
