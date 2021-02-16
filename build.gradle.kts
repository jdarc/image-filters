plugins {
    kotlin("jvm") version "1.4.30"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.mortennobel:java-image-scaling:0.8.6")
}

application {
    mainClass.set("Program")
}
