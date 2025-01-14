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

include(":composecolors:core")
project(":composecolors:core").projectDir = file("library/core")

include(":composecolors:material")
project(":composecolors:material").projectDir = file("library/material")
include(":composecolors:materialpalette")
project(":composecolors:materialpalette").projectDir = file("library/material-palette")

include(":composecolors:x11")
project(":composecolors:x11").projectDir = file("library/x11")
include(":composecolors:x11palette")
project(":composecolors:x11palette").projectDir = file("library/x11-palette")

// Demo App - used for the screenshots
include(":demo:desktop")