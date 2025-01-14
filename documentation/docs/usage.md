---
icon: material/keyboard
---

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