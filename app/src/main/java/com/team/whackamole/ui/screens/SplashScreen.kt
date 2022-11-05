package com.team.whackamole.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.team.whackamole.R
import com.team.whackamole.ui.Route

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background_forest),
                contentScale = ContentScale.Crop
            )

    ) {
        Button(
            onClick = {
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