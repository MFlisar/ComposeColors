dependencyResolutionManagement {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }

    versionCatalogs {
        create("app") {
            from(files("gradle/app.versions.toml"))
        }
    }
}

pluginManagement {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

// --------------
// Library
// --------------

include(":ComposeColors:Material")
project(":ComposeColors:Material").projectDir = file("library/material")

include(":ComposeColors:X11")
project(":ComposeColors:X11").projectDir = file("library/x11")

// Demo App - used for the screenshots
include(":demo:desktop")