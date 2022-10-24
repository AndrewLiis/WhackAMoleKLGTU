package com.team.whackamole.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun MenuScreen(navController: NavController) {
    Column {
        Text("Hello", style = TextStyle(fontSize = 22.sp))
        Text("World", style = TextStyle(fontSize = 22.sp))
        Text("from", style = TextStyle(fontSize = 22.sp))
        Text("Jetpack Compose", style = TextStyle(fontSize = 22.sp))
    }
}