plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    
    // Rest Assured
    testImplementation("io.rest-assured:rest-assured:5.3.2")
    testImplementation("io.rest-assured:json-schema-validator:5.3.2")
    
    // JSON işlemleri için
    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    
    // Assertion'lar için
    testImplementation("org.assertj:assertj-core:3.24.2")
    
    // Log işlemleri için
    testImplementation("org.slf4j:slf4j-api:2.0.7")
    testImplementation("ch.qos.logback:logback-classic:1.4.11")
}

tasks.test {
    useJUnitPlatform()
}