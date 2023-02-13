plugins {
    id("java")
    id("maven-publish")
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

group = "pro.nocom.legacysmp"
version = "1.0.0"
description = "Library plugin"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    compileOnly("org.bukkit:asclepius:1.1.7")
}

bukkit {
    main = "pro.nocom.legacysmp.legacylib.Main"
    author = "Allink"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}