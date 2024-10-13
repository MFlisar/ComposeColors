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

include(":ComposeColors:Core")
project(":ComposeColors:Core").projectDir = file("library/core")

include(":ComposeColors:Material")
project(":ComposeColors:Material").projectDir = file("library/material")
include(":ComposeColors:MaterialPalette")
project(":ComposeColors:MaterialPalette").projectDir = file("library/material-palette")

include(":ComposeColors:X11")
project(":ComposeColors:X11").projectDir = file("library/x11")
include(":ComposeColors:X11Palette")
project(":ComposeColors:X11Palette").projectDir = file("library/x11-palette")

// Demo App - used for the screenshots
include(":demo:desktop")