plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(Dependencies.retorfit)
    implementation (Dependencies.gson_converter)
    implementation(Dependencies.okHtttp)
    implementation (Dependencies.javaxInject)
    implementation(project(":domain"))
}