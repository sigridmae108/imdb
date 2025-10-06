plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.testng:testng:7.10.2")
    implementation("com.codeborne:selenide:7.11.1")
    testImplementation("io.qameta.allure:allure-selenide:2.30.0")
}

tasks.test {
    useTestNG()
}