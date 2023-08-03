import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

val MODULE_PACKAGE_NAME: String by project
val MODULE_NAME: String by project
val MODULE_VERSION_NUMBER: String by project
val PUBLISH_NAME: String by project

group = MODULE_PACKAGE_NAME
version = MODULE_VERSION_NUMBER

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jlleitschuh.gradle.ktlint")
    id("io.gitlab.arturbosch.detekt")
    signing
    `maven-publish`
}

ktlint {
    version.set("0.43.0")
}

detekt {
    config = files("./custom-detekt-config.yml")
    buildUponDefaultConfig = true // preconfigure defaults
    input = files("src/commonMain/kotlin")
    autoCorrect = false

    reports {
        html.enabled = true
        xml.enabled = true
        txt.enabled = true
        sarif.enabled = true
    }
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    // Target version of the generated JVM bytecode. It is used for type resolution.
    jvmTarget = "1.8"
}

kotlin {
    js(BOTH) {
        browser { }
    }
    android {
        publishAllLibraryVariants()
        publishLibraryVariantsGroupedByFlavor = true
    }
    val xcf = XCFramework(MODULE_NAME)
    ios {
        binaries.framework {
            baseName = MODULE_NAME
            xcf.add(this)
        }
    }
    iosSimulatorArm64 {
        binaries.framework {
            baseName = MODULE_NAME
            xcf.add(this)
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jsMain by getting
        val jsTest by getting
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting
        val iosSimulatorArm64Main by getting
        iosSimulatorArm64Main.dependsOn(iosMain)
        val iosTest by getting
        val iosSimulatorArm64Test by getting
        iosSimulatorArm64Test.dependsOn(iosTest)
    }
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 23
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

fun SigningExtension.whenRequired(block: () -> Boolean) {
    setRequired(block)
}

val javadocJar by tasks.creating(Jar::class) {
    archiveClassifier.value("javadoc")
}

publishing {
    val OPEN_SOURCE_REPO: String by project
    val PUBLISH_DESCRIPTION: String by project
    val PUBLISH_URL: String by project
    val POM_DEVELOPER_ID: String by project
    val POM_DEVELOPER_NAME: String by project
    val POM_DEVELOPER_EMAIL: String by project
    val PUBLISH_SCM_URL: String by project
    val PUBLISH_SCM_CONNECTION: String by project
    val PUBLISH_SCM_DEVELOPERCONNECTION: String by project

    repositories {
        maven {
            url = uri(OPEN_SOURCE_REPO)

            credentials {
                username = System.getenv("sonatypeUsernameEnv")
                password = System.getenv("sonatypePasswordEnv")
            }
        }
    }

    publications.all {
        this as MavenPublication

        artifact(javadocJar)

        pom {
            name.set(PUBLISH_NAME)
            description.set(PUBLISH_DESCRIPTION)
            url.set(PUBLISH_URL)

            licenses {
                license {
                    name.set("MIT License")
                    url.set("http://opensource.org/licenses/MIT")
                }
            }

            developers {
                developer {
                    id.set(POM_DEVELOPER_ID)
                    name.set(POM_DEVELOPER_NAME)
                    email.set(POM_DEVELOPER_EMAIL)
                }
            }

            scm {
                url.set(PUBLISH_SCM_URL)
                connection.set(PUBLISH_SCM_CONNECTION)
                developerConnection.set(PUBLISH_SCM_DEVELOPERCONNECTION)
            }
        }
    }
}

signing {
    whenRequired { gradle.taskGraph.hasTask("publish") }
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}
