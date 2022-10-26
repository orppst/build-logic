
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

    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:2.13.1.Final"))
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

tasks.test {
    useJUnitPlatform()
}
