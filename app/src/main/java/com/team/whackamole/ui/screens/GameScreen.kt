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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import com.team.whackamole.R
import org.intellij.lang.annotations.JdkConstants.FlowLayoutAlignment

@Composable
fun GameScreen(navController: NavController) {
    NestedScrollScreen()
}


@Composable
fun NestedScrollScreen() {
    val books = (1..10).map { "Book $it" }.toList()
    val wishlisted = (1..500).map { "Wishlisted Book $it" }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Верхний горизонтальный скролл
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("My Books", style = MaterialTheme.typography.h4)
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(books) { item ->
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .height(120.dp)
                                .width(90.dp)
                                .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
                        ) {
                            Text(item, modifier = Modifier.align(Alignment.Center))
                        }
                    }
                }
            }

        }
        item {
            Text("Whishlisted Books", style = MaterialTheme.typography.h4)
        }
        // Нижний вертикальный скролл
        items(wishlisted.windowed(3,3,false)) { sublist ->
            //Непонятно лагает ли скролл из-за Arrangement
            Row( horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxSize()
            ) {
                sublist.forEach { item ->
                    Text(
                        item, modifier = Modifier
                            .height(120.dp)
                            .background(Color.Blue)
                            .fillParentMaxWidth(.30f)
                            .clickable(onClick = { Log.d("BTN", item) })
                    )
                }
            }
        }
        item { Text(text = "Привет из джекпак компоуза") }
    }
}





