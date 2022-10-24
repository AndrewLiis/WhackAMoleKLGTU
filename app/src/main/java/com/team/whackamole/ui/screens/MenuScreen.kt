package com.team.whackamole.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.team.whackamole.R


@Composable
fun MenuScreen(navController: NavController) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop
            )
    ) {
        Button(onClick = {
            //Navigation on game screen
        }, modifier = Modifier.padding(30.dp).fillMaxWidth()
        ) {
            Text("Начать игру", fontSize = 25.sp)
        }
        Button(onClick = {
            //Navigation on store screen
        }, modifier = Modifier.padding(30.dp, 15.dp).fillMaxWidth()
        ) {
            Text("Магазин", fontSize = 25.sp)
        }
        Button(onClick = {
            //Navigation on settings screen
        }, modifier = Modifier.padding(30.dp).fillMaxWidth()
        ) {
            Text("Настройки", fontSize = 25.sp)
        }
    }
}