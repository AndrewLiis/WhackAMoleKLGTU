package com.team.whackamole.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.team.whackamole.R
import com.team.whackamole.ui.viewmodels.GameViewModel
import org.intellij.lang.annotations.JdkConstants.FlowLayoutAlignment

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameScreen(navController: NavController) {
    val list = (1..12).map { it.toString() }

    //val timerValue = viewModel.timerValue.observeAsState()
    Box(
        modifier = Modifier
        .fillMaxSize()
        .paint(
        painterResource(
            id = R.drawable.background_forest),
            contentScale = ContentScale.Crop
        )) {

        Text("Счет", modifier = Modifier.align(Alignment.TopStart).padding(10.dp))
        Text("Таймер", modifier = Modifier.align(Alignment.TopCenter).padding(10.dp))
        Text("Меню", modifier = Modifier.align(Alignment.TopEnd).padding(10.dp))

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            cells = GridCells.Fixed(3),
            content = {
                items(list.size) { index ->

                    val mole: Painter = painterResource(id = R.drawable.hole_with_mole)
                    val moleV2: Painter = painterResource(id = R.drawable.mole_v2)
                    val hole: Painter = painterResource(id = R.drawable.hole)
                    val holeV2: Painter = painterResource(id = R.drawable.hole_v2)
                    val holeV3: Painter = painterResource(id = R.drawable.hole_v3)

                    Box(
                        contentAlignment = Alignment.BottomCenter,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .aspectRatio(1f),
                    ) {
                        if (index == 5) {
                            Image(painter = holeV2, contentDescription = "")
                            Image(painter = moleV2, contentDescription = "")

                        } else {
                            Image(painter = holeV2, contentDescription = "")
                        }
                    }
                }
            }
        )
    }
}






