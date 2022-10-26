plugins {
    id("java-platform")

}

group = "org.orph2020.pst.platforms"
// see https://melix.github.io/blog/2021/03/version-catalogs-faq.html & https://github.com/gradle/gradle/issues/16078
// thried the below, but it does not work as it eventually gets evaluated int the project tha apples the plugin where then are no such catalogs.
//val catalogs = extensions.getByType<VersionCatalogsExtension>()
//val libs = catalogs.named("libs")

dependencies {
    constraints {

 //  api(enforcedPlatform(libs.findLibrary("quarkus-platform")))
    }
}
