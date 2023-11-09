plugins {
    alias(testingLibs.plugins.kover)
}

kover {
    engine.set(kotlinx.kover.api.DefaultIntellijEngine)
}

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jlleitschuh.gradle.ktlint:org.jlleitschuh.gradle.ktlint.gradle.plugin:11.0.0")
        classpath(libs.android.build.tools)
        classpath(libs.gradle.plugin)
        classpath(testingLibs.detekt)
        classpath(testingLibs.kotest.plugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}
