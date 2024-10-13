[![Maven](https://img.shields.io/maven-central/v/io.github.mflisar.composecolors/core?style=for-the-badge&color=blue)](https://central.sonatype.com/namespace/io.github.mflisar.composecolors)
[![API](https://img.shields.io/badge/api-21%2B-brightgreen.svg?style=for-the-badge)](https://android-arsenal.com/api?level=21)
[![Kotlin](https://img.shields.io/github/languages/top/mflisar/kotpreferences.svg?style=for-the-badge&color=blueviolet)](https://kotlinlang.org/)
[![KMP](https://img.shields.io/badge/Kotlin_Multiplatform-blue?style=for-the-badge&label=Kotlin)](https://kotlinlang.org/docs/multiplatform.html)
[![License](https://img.shields.io/github/license/MFlisar/ComposeColors?style=for-the-badge)](LICENSE)

<h1 align="center">ComposeColors</h1>

A simple collection of colors that can be used inside any KMP Compose project.

## :heavy_check_mark: Features

This library simple defines color constants for all `MaterialColors` or all `X11 colors`.

**All features are splitted into separate modules, just include the modules you want to use!**

## :camera: Screenshots

|    ![Demo](screenshots/material.png "Material Colors")    | ![Demo](screenshots/x11.png "X11 Colors") |
|:---------------------------------------------------------:|:-----------------------------------------:|
|                      Material Colors                      |                X11 Colors                 |

## :elephant: Gradle

This library is distributed via [maven central](https://central.sonatype.com/).

*build.gradle.kts*

```kts
val composecolors = "<LATEST-VERSION>"

implementation("io.github.mflisar.composecolors:material:$composecolors")
implementation("io.github.mflisar.composecolors:x11:$composecolors")
```

## </> Usage

```kotlin

// returns instance of `androidx.compose.ui.graphics.Color`

// Material Colors
val red500 = MaterialColor.Red500

// X11 Colors
val aliceBlue = X11.AliceBlue
```

## :computer: Supported Platforms

**Supported Platforms**

This is a **KMP (kotlin multiplatform)** library and the provided modules do support following platforms:

| Modules  | Android | iOS | jvm | js |
|:---------|---------|-----|-----|----|
| material | √       | √   | √   | √  |
| x11      | √       | √   | √   | √  |