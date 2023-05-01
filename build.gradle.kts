plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(files(".lib/algs4.jar",".lib/introcs.jar","lib/stdlib.jar"))
}

tasks.test {
    useJUnitPlatform()
}