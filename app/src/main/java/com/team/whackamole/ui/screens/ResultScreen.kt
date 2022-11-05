package com.team.whackamole.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.team.whackamole.R
import com.team.whackamole.resources.Constants
import com.team.whackamole.ui.Route

@Composable
fun ResultScreen(navController: NavController, score: String?) {

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
        Text(
            text = Constants.gameOver,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "${Constants.youScored} $score очков",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { navController.navigate(Route.MenuScreenRoute.path){
                popUpTo(Route.ResultScreen.path) {
                    inclusive = true
                }
            } },
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                text = Constants.backToMenu,
                fontSize = 30.sp,
                color = Color.White,
            )
        }
    }

}