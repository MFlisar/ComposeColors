package com.michaelflisar.composecolors

sealed class ColorPalette {

    abstract val name: String
    abstract val colors: List<Color>

    class Grouped(
        override val name: String,
        val groups: List<ColorGroup>
    ) : ColorPalette() {
        override val colors: List<Color>
            get() = groups.map { it.colors }.flatten()
    }

    class Definition(
        override val name: String,
        override val colors: List<Color>
    ) : ColorPalette()
}