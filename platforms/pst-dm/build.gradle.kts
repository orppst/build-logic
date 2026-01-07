plugins {
    id("java-platform")
}

group = "org.orph2020.pst.platforms"
javaPlatform.allowDependencies()


dependencies {
    api("org.javastro.ivoa.dm:proposaldm:0.6.6:quarkus")//IMPL special dependency that does not include the
    api("org.javastro.ivoa.dm:proposaldm:0.6.6:test") // FIXME will want to remove for deployment
}
