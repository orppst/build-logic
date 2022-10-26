pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
}
//val quarkusVersion: String by settings
dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
    }

    // think that version catalogues are almost useless in  plugin/platform use cases - it seems just about impossible to consume them
//    versionCatalogs {
//        create("libs") {
//            version("quarkusVersion", quarkusVersion)
//            library("quarkus-platform", "io.quarkus.platform", "quarkus-bom").versionRef("quarkusVersion")
//            plugin("quarkus-plugin", "io.quarkus").version(quarkusVersion)
//        }
//    }
}
rootProject.name = "pst-build-logic"
includeBuild("platforms")
include("common")