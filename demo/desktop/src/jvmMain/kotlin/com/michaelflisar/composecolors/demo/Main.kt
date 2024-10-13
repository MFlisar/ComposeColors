package com.michaelflisar.composecolors.demo

import androidx.compose.foundation.background
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.michaelflisar.composecolors.material.MaterialColor
import com.michaelflisar.composecolors.x11.X11Color
import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberProperties


fun main() {

    application {

        Window(
            title = "Compose Colors Demo",
            onCloseRequest = ::exitApplication,
            state = rememberWindowState(
                position = WindowPosition(Alignment.Center),
                width = 800.dp,
                height = 600.dp
            )
        ) {
            val colors: Any = MaterialColor
            val colorNames = if (colors is MaterialColor) listOf(
                "Red",
                "Pink",
                "Purple",
                "DeepPurple",
                "Indigo",
                "Blue",
                "LightBlue",
                "Cyan",
                "Teal",
                "Green",
                "LightGreen",
                "Lime",
                "Yellow",
                "Amber",
                "Orange",
                "DeepOrange",
                "Brown",
                "Gray",
                "BlueGray",
                "B/W"
            ) else null
            val cellSize = if (colors is MaterialColor) 32.dp else 48.dp
            val columns = if (colors is MaterialColor) 14 else 10

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                val list: ArrayList<Pair<Color, String>> = ArrayList()
                colors::class.memberProperties.forEach {
                    if (it.visibility == KVisibility.PUBLIC) {
                        list.add(Pair(it.getter.call(colors) as Color, it.name))
                    }
                }

                if (colorNames == null) {
                    val colors = list.chunked(columns)
                    colors.forEach {
                        ColorRow(null, it, columns, cellSize)
                    }
                } else {

                    colorNames.forEach { name ->
                        val filtered = if (name == colorNames.last()) {
                            list.filter { it.second == "Black" || it.second == "White" }
                        } else list.filter {
                            it.second.filter { it.isLetter() } == name ||
                                    it.second.filter { it.isLetter() } == "${name}A"
                        }
                        ColorRow(name, filtered, columns, cellSize)
                    }
                }
            }
        }
    }
}

@Composable
fun ColorRow(
    name: String?,
    colors: List<Pair<Color, String>>,
    columns: Int,
    cellSize: Dp
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
            ColorCell(Modifier.weight(1f), it.first, it.second)

        }
        for (i in colors.size..<columns) {
            ColorCell(Modifier.weight(1f), Color.Transparent, "")
        }
    }
}

@Composable
fun ColorCell(
    modifier: Modifier,
    color: Color,
    name: String
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.small)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(name, fontSize = 8.sp)
    }
}