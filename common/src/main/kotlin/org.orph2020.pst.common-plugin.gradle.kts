import io.quarkus.gradle.tasks.QuarkusTask

plugins {// even after all that above the variable is not available in scope https://stackoverflow.com/questions/60165254/how-to-parametrize-kotlin-version-in-the-plugins-block-of-a-build-gradle-kts-scr
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

group = "org.orph2020.pst"

dependencies {

    implementation(enforcedPlatform("org.orph2020.pst.platforms:quarkus-base"))
    implementation("io.quarkus:quarkus-container-image-docker") // or perhaps below is better - esp if you do not have docker installed...
//    implementation("io.quarkus:quarkus-container-image-jib")
    implementation("io.quarkus:quarkus-minikube")
    testImplementation("io.quarkus:quarkus-junit5")
}


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
// https://quarkus.io/guides/gradle-tooling https://quarkus.io/guides/config-reference
// set some global quarkus properties here - note that the systemProperty() call
// recommended in first of above does not seem to work - so doing the more obvious direct java call
// note also that these are build time properties - run time stuff should still go into each application.properties.
tasks.withType<QuarkusTask> {
    System.setProperty("quarkus.container-image.registry","130.88.9.40:9083") // http://redmine.jb.man.ac.uk/issues/6457
    System.setProperty("quarkus.kubernetes.part-of","proposalTool")
    System.setProperty("quarkus.container-image.group", "orppst")
}

tasks.test {
    useJUnitPlatform()
}
