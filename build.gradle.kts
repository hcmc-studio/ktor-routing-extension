plugins {
    kotlin("jvm") version "1.9.0"
    id("maven-publish")
}

group = "studio.hcmc"
version = "0.0.5"

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "studio.hcmc"
            artifactId = "ktor-plugin-accepted-at"
            version = "0.0.5"
            from(components["java"])
        }
    }
}

dependencies {
    implementation("com.github.hcmc-studio:kotlin-protocol-extension:0.0.4-release")
    implementation("com.github.hcmc-studio:ktor-plugin-accepted-at:0.0.4-release")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime-jvm:0.4.0")

    implementation("io.ktor:ktor-server-core-jvm:2.3.2")
}