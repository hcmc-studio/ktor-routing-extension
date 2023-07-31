plugins {
    kotlin("jvm") version "1.9.0"
}

group = "studio.hcmc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":kotlin-protocol-extension"))
    implementation(project(":ktor-plugin-extension"))

    implementation("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.4.0")

    implementation("io.ktor:ktor-server-core-jvm:2.3.2")
}

kotlin {
    jvmToolchain(17)
}