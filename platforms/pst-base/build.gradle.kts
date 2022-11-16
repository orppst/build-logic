plugins {
    id("java-platform")

}

group = "org.orph2020.pst.platforms"
javaPlatform.allowDependencies()


dependencies {
    api(platform("org.orph2020.pst.platforms:pst-dm"))
    api("org.orph2020.pst:pst-lib")

}
