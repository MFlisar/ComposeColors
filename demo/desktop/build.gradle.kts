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

                implementation(project(":ComposeColors:Material"))
                implementation(project(":ComposeColors:X11"))

                // Reflection to get a list of all colors for demo purposes
                implementation(kotlin("reflect"))
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