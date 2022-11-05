package com.team.whackamole.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.team.whackamole.R
import com.team.whackamole.resources.Constants

@Composable
fun AuthScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background_forest),
                contentScale = ContentScale.Crop,
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var login by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Text(
            text = "Войти",
            fontSize = Constants.mainFontSize.sp,
            color = Color.White
        )

        OutlinedTextField(
            value = login,
            singleLine = true,
            maxLines = 1,
            textStyle = TextStyle(fontSize = 20.sp),
            onValueChange = { login = it },
            label = { Text("Логин", fontSize = 20.sp) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier
            .height(Constants.vertSpacerHeight.dp)
            .fillMaxWidth())

        OutlinedTextField(
            value = password,
            singleLine = true,
            maxLines = 1,
            textStyle = TextStyle(fontSize = 20.sp),
            onValueChange = { password = it },
            label = { Text("Пароль", fontSize = 20.sp) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        
        Spacer(modifier = Modifier
            .height(Constants.vertSpacerHeight.dp)
            .fillMaxWidth()
        )
        
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Регистрация", fontSize = Constants.buttonFontSize.sp)
        }
    }
}