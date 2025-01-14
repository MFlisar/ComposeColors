import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose)
}

kotlin {

    jvm {
        withJava()
    }

    sourceSets {
        val jvmMain by getting {
            dependencies {

                implementation(compose.desktop.currentOs)

                implementation(project(":composecolors:material"))
                implementation(project(":composecolors:x11"))

                implementation(project(":composecolors:materialpalette"))
                implementation(project(":composecolors:x11palette"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.michaelflisar.composecolors.demo.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Exe)
            packageName = "Compose Colors Demo"
            packageVersion = "1.0.0"
        }
    }
}