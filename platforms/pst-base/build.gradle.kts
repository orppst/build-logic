plugins {
    id("java-platform")

}

group = "org.orph2020.pst.platforms"


dependencies {
    constraints {
        api(enforcedPlatform("io.quarkus.platform:quarkus-bom:3.33.3.2"))
        api("org.javastro.ivoa.dm:proposaldm:0.7.1-SNAPSHOT")
    }
}
