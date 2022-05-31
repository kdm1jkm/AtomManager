import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val exposedVersion: String by project
group = "com.github.kdm1jkm"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    // https://mvnrepository.com/artifact/com.h2database/h2
    testImplementation("com.h2database:h2:2.1.212")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}