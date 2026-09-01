/*NOTE: THIS IS A FNMA-FRIENDLY BUILD.GRADLE file

The build.gradle is the main config file for gradle projects

-the repositories block defines WHERE we'll get dependencies from
-the dependencies block defines WHAT dependencies we want
*/


plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

//POINTING TO FNMA'S INTERNAL DEPENDENCY REPO (Nexus)
repositories {
    mavenLocal()
    maven {
        url = uri("https://nexusrepository.fanniemae.com/nexus/repository/public/")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:1.5.18")
    implementation("org.xerial:sqlite-jdbc:3.50.3.0")
}

tasks.test {
    useJUnitPlatform()
}