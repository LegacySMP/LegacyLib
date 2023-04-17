plugins {
    id("java")
    id("maven-publish")
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

group = "pro.nocom.legacysmp"
version = "1.1.0-SNAPSHOT"
description = "Library plugin"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    compileOnly("org.bukkit:asclepius:1.1.7")
}

bukkit {
    main = "pro.nocom.legacysmp.legacylib.LegacyLib"
    author = "Allink"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }

    repositories {
        // ./gradlew --no-daemon publishMavenPublicationToReleasesRepository
        maven {
            name = "releases"
            url = uri("https://maven.allink.esixtwo.one/releases")
            credentials {
                username = System.getenv("allinkMavenUser")
                password = System.getenv("allinkMavenPassword")
            }
        }

        // ./gradlew --no-daemon publishMavenPublicationToSnapshotsRepository
        maven {
            name = "snapshots"
            url = uri("https://maven.allink.esixtwo.one/snapshots")
            credentials {
                username = System.getenv("allinkMavenUser")
                password = System.getenv("allinkMavenPassword")
            }
        }
    }
}