plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.protobuf.gradle.plugin)
    id("maven-publish")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlin.stdlib.jdk8)

    api(libs.protobuf.java)

    compileOnly(project(":android-api"))
}

protobuf {
    protoc {
        // The artifact spec for the Protobuf Compiler
        artifact = "com.google.protobuf:protoc:3.25.2"
    }
}


val GROUP_ID = "shortx"
val ARTIFACT_ID = "plugin.sdk"
val VERSION = latestGitTag().ifEmpty { "1.0.0" }

fun latestGitTag(): String {
    val process = ProcessBuilder("git", "describe", "--tags", "--abbrev=0").start()
    return process.inputStream.bufferedReader().use { bufferedReader ->
        bufferedReader.readText().trim()
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = GROUP_ID
            artifactId = ARTIFACT_ID
            version = VERSION

            afterEvaluate {
                from(components["java"])
            }
        }
    }
}