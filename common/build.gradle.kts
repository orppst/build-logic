plugins {
    `kotlin-dsl`
}
val quarkusVersion = project.properties["quarkusVersion"]
dependencies {
    implementation("io.quarkus:gradle-application-plugin:${quarkusVersion}")
}