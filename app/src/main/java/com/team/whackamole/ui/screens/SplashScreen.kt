package com.team.whackamole.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.team.whackamole.ui.Route
import com.team.whackamole.R

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.ic_launcher_background), contentScale = ContentScale.Crop)

    ) {
        Button(onClick = {
            navController.navigate(Route.MenuScreenRoute.path) {
                popUpTo(Route.SplashScreenRoute.path) {
                    inclusive = true
                }
            }
        }, modifier = Modifier
            .offset(0.dp, 0.dp)
        ) {
            Text("Старт", fontSize = 25.sp)
        }
    }
}