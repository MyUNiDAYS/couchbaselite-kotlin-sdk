plugins {
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
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
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jlleitschuh.gradle.ktlint:org.jlleitschuh.gradle.ktlint.gradle.plugin:11.0.0")
        classpath("io.gitlab.arturbosch.detekt:io.gitlab.arturbosch.detekt.gradle.plugin:1.22.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}
