import io.quarkus.gradle.tasks.QuarkusTask

plugins {// even after all that above the variable is not available in scope https://stackoverflow.com/questions/60165254/how-to-parametrize-kotlin-version-in-the-plugins-block-of-a-build-gradle-kts-scr
    java
    id("io.quarkus")
}

//this does not always seem to be inherited?
repositories {
    mavenCentral()
    mavenLocal()
    /*
    add this repository to pick up the SNAPSHOT version of the IVOA base library - in the future  this
    will not be necessary when this library is released as a non-SNAPSHOT version.
     */
    maven {
        url= uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }

}

group = "org.orph2020.pst"

dependencies {

    implementation(enforcedPlatform("org.orph2020.pst.platforms:quarkus-base"))
    implementation("io.quarkus:quarkus-container-image-docker") // or perhaps below is better - esp if you do not have docker installed... use docker for now because of permissions
//   implementation("io.quarkus:quarkus-container-image-jib")
    implementation("io.quarkus:quarkus-kubernetes")
    implementation(platform("org.orph2020.pst.platforms:pst-base"))
    testImplementation("io.quarkus:quarkus-junit5")
}



tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
// https://quarkus.io/guides/gradle-tooling#configuring-quarkus-builds https://quarkus.io/guides/config-reference
// set some global quarkus properties here - note that the systemProperty() call
// recommended in first of above does not seem to work - so doing the more obvious direct java call
// note also that these are build time properties - run time stuff should still go into each application.properties.
tasks.withType<QuarkusTask>().configureEach {
    System.setProperty("quarkus.container-image.registry","kilburn.jb.man.ac.uk") // http://redmine.jb.man.ac.uk/issues/6457
    System.setProperty("quarkus.container-image.group", "orppst")
    System.setProperty("quarkus.container-image.build", "true")
    System.setProperty("quarkus.kubernetes.part-of","proposalTool")
    System.setProperty("quarkus.kubernetes.namespace","orp-pst")
    System.setProperty("quarkus.kubernetes.deploy","false")
}

tasks.test {
    useJUnitPlatform()
}
