plugins {
    java
    application
}

group = "com.richardtowers"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile("org.slf4j", "slf4j-simple", "1.7.25")
    compile("io.javalin", "javalin", "2.3.0")
    testCompile("org.junit.jupiter", "junit-jupiter-api", "5.3.1")
    testCompile("org.junit.jupiter", "junit-jupiter-params", "5.3.1")
    testRuntime("org.junit.jupiter", "junit-jupiter-engine", "5.3.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

application {
    mainClassName = "HelloInternet"
}

val distZip = tasks.getByName<Zip>("distZip")
distZip.archiveName = "${distZip.baseName}.${distZip.extension}"
