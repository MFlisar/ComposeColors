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
        create("deps") {
            from(files("gradle/deps.versions.toml"))
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
// Functions
// --------------

fun includeModule(path: String, name: String) {
    include(name)
    project(name).projectDir = file(path)
}

// --------------
// Library
// --------------

includeModule("library/core", ":composecolors:core")
includeModule("library/material", ":composecolors:material")
includeModule("library/material-palette", ":composecolors:materialpalette")
includeModule("library/x11", ":composecolors:x11")
includeModule("library/x11-palette", ":composecolors:x11palette")

// --------------
// Demo
// --------------

include(":demo:desktop")