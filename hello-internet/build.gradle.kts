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
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}

application {
    mainClassName = "HelloInternet"
}
