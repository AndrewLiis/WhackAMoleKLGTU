package com.team.whackamole.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.team.whackamole.R
import com.team.whackamole.ui.Route
import com.team.whackamole.ui.viewmodels.GameViewModel
import org.koin.androidx.compose.getViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameScreen(navController: NavController) {

    val list = (1..12).map { it.toString() }

    val gameViewModel = getViewModel<GameViewModel>()
    val userScore by remember { gameViewModel.userScore }
    val timerValue by remember { gameViewModel.timerValue }
    val molePosition = gameViewModel.molePosition.observeAsState()
    val isTimerFinish = gameViewModel.isTimerFinish.observeAsState()
    val isMoleVisible = gameViewModel.isMoleVisible.observeAsState()

    if (isTimerFinish.value == true) {
        LaunchedEffect(true) {
            navController.navigate(Route.ResultScreen.withArgs(gameViewModel.userScore.value.toString()))
        }
        gameViewModel.isTimerFinish.value = false
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(
                    id = R.drawable.background_forest
                ),
                contentScale = ContentScale.Crop
            )
    ) {

        Text(
            text = userScore.toString(),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(10.dp)
        )

        Text(
            text = timerValue,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(10.dp)
        )

        Text(
            "Меню", modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(10.dp)
        )

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            cells = GridCells.Fixed(3),
            content = {
                items(list.size) { index ->

                    val moleV2: Painter = painterResource(id = R.drawable.mole_v2)
                    val holeV2: Painter = painterResource(id = R.drawable.hole_v2)

                    Box(
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .aspectRatio(1f),
                    ) {
                        if (index == molePosition.value) {
                            Image(painter = holeV2, contentDescription = "")

                            if (isMoleVisible.value == true) {
                                Image(painter = moleV2, contentDescription = "",
                                    modifier = Modifier.clickable {
                                        gameViewModel.upScore()
                                        gameViewModel.hideMole()
                                        gameViewModel.moveMoleOnRandomPosition()
                                    })
                            }

                        } else {
                            Image(painter = holeV2, contentDescription = "")
                        }
                    }
                }
            }
        )
    }
}






