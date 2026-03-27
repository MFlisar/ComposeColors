[![Maven Central](https://img.shields.io/maven-central/v/io.github.mflisar.composecolors/core?style=for-the-badge&color=blue)](https://central.sonatype.com/artifact/io.github.mflisar.composecolors/core) ![API](https://img.shields.io/badge/api-24%2B-brightgreen.svg?style=for-the-badge) ![Kotlin](https://img.shields.io/github/languages/top/MFlisar/ComposeColors.svg?style=for-the-badge&amp;color=blueviolet) ![Kotlin Multiplatform](https://img.shields.io/badge/Kotlin_Multiplatform-blue?style=for-the-badge&amp;label=Kotlin)
# ComposeColors
![Platforms](https://img.shields.io/badge/PLATFORMS-black?style=for-the-badge) ![Android](https://img.shields.io/badge/android-3DDC84?style=for-the-badge) ![iOS](https://img.shields.io/badge/ios-A2AAAD?style=for-the-badge) ![Windows](https://img.shields.io/badge/windows-5382A1?style=for-the-badge) ![macOS](https://img.shields.io/badge/macos-B0B0B0?style=for-the-badge) ![WebAssembly](https://img.shields.io/badge/wasm-624DE7?style=for-the-badge)

This library offers you **compose color definitions** and optionally also palettes for the colors.

> [!NOTE]
> All features are splitted into separate modules, just include the modules you want to use!

# Table of Contents

- [Screenshots](#camera-screenshots)
- [Supported Platforms](#computer-supported-platforms)
- [Versions](#arrow_right-versions)
- [Setup](#wrench-setup)
- [Usage](#rocket-usage)
- [Demo](#sparkles-demo)
- [API](#books-api)
- [Other Libraries](#bulb-other-libraries)

# :camera: Screenshots

![x11](documentation/screenshots/x11/x11.png)
![material](documentation/screenshots/material/material.png)

# :computer: Supported Platforms

| Module | android | iOS | windows | macOS | wasm |
|---|---|---|---|---|---|
| core | ✅ | ✅ | ✅ | ✅ | ✅ |
| material | ✅ | ✅ | ✅ | ✅ | ✅ |
| material-palette | ✅ | ✅ | ✅ | ✅ | ✅ |
| x11 | ✅ | ✅ | ✅ | ✅ | ✅ |
| x11-palette | ✅ | ✅ | ✅ | ✅ | ✅ |

# :arrow_right: Versions

| Dependency | Version |
|---|---|
| Kotlin | `2.3.20` |
| Jetbrains Compose | `1.10.3` |
| Jetbrains Compose Material3 | `1.9.0` |

# :wrench: Setup

<details open>

<summary><b>Using Version Catalogs</b></summary>

<br>

Define the dependencies inside your **libs.versions.toml** file.

```toml
[versions]

composecolors = "<LATEST-VERSION>"

[libraries]

composecolors-core = { module = "io.github.mflisar.composecolors:core", version.ref = "composecolors" }
composecolors-material = { module = "io.github.mflisar.composecolors:material", version.ref = "composecolors" }
composecolors-material-palette = { module = "io.github.mflisar.composecolors:material-palette", version.ref = "composecolors" }
composecolors-x11 = { module = "io.github.mflisar.composecolors:x11", version.ref = "composecolors" }
composecolors-x11-palette = { module = "io.github.mflisar.composecolors:x11-palette", version.ref = "composecolors" }
```

And then use the definitions in your projects **build.gradle.kts** file like following:

```java
implementation(libs.composecolors.core)
implementation(libs.composecolors.material)
implementation(libs.composecolors.material.palette)
implementation(libs.composecolors.x11)
implementation(libs.composecolors.x11.palette)
```

</details>

<details>

<summary><b>Direct Dependency Notation</b></summary>

<br>

Simply add the dependencies inside your **build.gradle.kts** file.

```kotlin
val composecolors = "<LATEST-VERSION>"

implementation("io.github.mflisar.composecolors:core:${composecolors}")
implementation("io.github.mflisar.composecolors:material:${composecolors}")
implementation("io.github.mflisar.composecolors:material-palette:${composecolors}")
implementation("io.github.mflisar.composecolors:x11:${composecolors}")
implementation("io.github.mflisar.composecolors:x11-palette:${composecolors}")
```

</details>

# :rocket: Usage

#### Basic examples

```kotlin

// returns instance of `androidx.compose.ui.graphics.Color`

// Material Colors
val red500 = MaterialColor.Red500
val blue500 = MaterialColor.Blue500
// ...

// X11 Colors
val aliceBlue = X11.AliceBlue
val antiqueWhite = X11.AntiqueWhite
// ...

```

#### Color Palettes

If desired, I offer `*-palette` modules that offer string names, enums and groups.

```kotlin

val palette = MaterialColor.Palette
when (palette) {
    is ColorPalette.Definition -> {
        // this palette does simple provide you a list of all available colors
        val paletteName: String = palette.name
        palette.colors.forEach {
            val colorName: String = it.name // e.g. AliceBlue, AntiqueWhite, Aqua, ...
            val color: Color = it.color
            // ...
        }
    }
    is ColorPalette.Grouped -> {
        val paletteName: String = palette.name
        palette.groups.forEach {
            val groupName: String = it.name // e.g. Red, Green, Blue, ...
            it.colors.forEach {
                val colorName: String = it.name  // e.g. Red500, Blue500, ...
                val color: Color = it.color
                // ...
            }
        }
    }
}
```

# :sparkles: Demo

A full [demo](/demo) is included inside the demo module, it shows nearly every usage with working examples.

# :books: API

Check out the [API documentation](https://MFlisar.github.io/ComposeColors/).

# :bulb: Other Libraries

You can find more libraries (all multiplatform) of mine that all do work together nicely [here](https://mflisar.github.io/Libraries/).
