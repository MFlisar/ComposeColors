package com.michaelflisar.composecolors.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.michaelflisar.composecolors.ColorPalette
import com.michaelflisar.composecolors.material.MaterialColor
import com.michaelflisar.composecolors.material.palette.Palette
import com.michaelflisar.composecolors.x11.X11Color
import com.michaelflisar.composecolors.x11.palette.Palette

fun main() {

    application {

        MaterialTheme {
            Window(
                title = "Compose Colors Demo",
                onCloseRequest = ::exitApplication,
                state = rememberWindowState(
                    position = WindowPosition(Alignment.Center),
                    width = 1024.dp,
                    height = 800.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var expanded by remember { mutableStateOf(false) }
                    val palettes = listOf(
                        MaterialColor.Palette,
                        X11Color.Palette
                    )
                    var selectedPalette by remember { mutableIntStateOf(0) }
                    Box {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = MaterialTheme.shapes.small
                                )
                                .padding(4.dp)
                                .clickable {
                                    expanded = true
                                }
                        ) {
                            Text(
                                text = palettes[selectedPalette].name,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = {
                                expanded = false
                            }
                        ) {
                            palettes.forEachIndexed { index, palette ->
                                DropdownMenuItem(
                                    text = { Text(text = palette.name) },
                                    onClick = {
                                        expanded = false
                                        selectedPalette = index
                                    }
                                )
                            }
                        }
                    }


                    val palette = remember(selectedPalette) { palettes[selectedPalette] }

                    val cellSize = if (palette == MaterialColor.Palette) 32.dp else 48.dp
                    val columns = if (palette == MaterialColor.Palette) 14 else 10
                    val textSize = if (palette == MaterialColor.Palette) 12.sp else 14.sp
                    val textProvider = if (palette == MaterialColor.Palette) {
                        { group: String?, color: com.michaelflisar.composecolors.Color ->
                            color.name.replace(group!!.replace(" ", ""), "")
                        }
                    } else {
                        { group: String?, color: com.michaelflisar.composecolors.Color ->
                            color.name
                        }
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        when (palette) {
                            is ColorPalette.Definition -> {
                                val colors = palette.colors.chunked(columns)
                                colors.forEach {
                                    ColorRow(null, it, columns, cellSize, textSize, textProvider)
                                }
                            }

                            is ColorPalette.Grouped -> {
                                palette.groups.forEach {
                                    ColorRow(
                                        it.name,
                                        it.colors,
                                        columns,
                                        cellSize,
                                        textSize,
                                        textProvider
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ColorRow(
    name: String?,
    colors: List<com.michaelflisar.composecolors.Color>,
    columns: Int,
    cellSize: Dp,
    textSize: TextUnit,
    textProvider: (group: String?, com.michaelflisar.composecolors.Color) -> String,
) {
    Row(
        modifier = Modifier.height(cellSize),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (name != null) {
            Text(text = name, modifier = Modifier.width(100.dp))
        }
        colors.forEach {
            ColorCell(Modifier.weight(1f), it.color, textProvider(name, it), textSize)

        }
        for (i in colors.size..<columns) {
            ColorCell(Modifier.weight(1f), Color.Transparent, "", textSize)
        }
    }
}

@Composable
fun ColorCell(
    modifier: Modifier,
    color: Color,
    name: String,
    textSize: TextUnit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.small)
            .background(color)
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            name,
            fontSize = textSize,
            textAlign = TextAlign.Center,
            color = if (color.luminance() <= .2f) Color.White else Color.Black
        )
    }
}