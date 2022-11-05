package com.team.whackamole.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.team.whackamole.R
import com.team.whackamole.resources.Constants
import com.team.whackamole.ui.Route

@Composable
fun RegistrationScreen(navController: NavController) {
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
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var login by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var passwordVisibility: Boolean by remember { mutableStateOf(false) }

                Spacer(modifier = Modifier
                    .height(Constants.vertSpacerHeight.dp)
                    .fillMaxWidth()
                )

                Text(
                    text = Constants.registration,
                    fontSize = Constants.bigFontSize.sp,
                    color = Color.Black
                )

                OutlinedTextField(
                    value = login,
                    singleLine = true,
                    maxLines = 1,
                    textStyle = TextStyle(fontSize = Constants.mediumFontSize.sp),
                    onValueChange = { login = it },
                    label = { Text(text = Constants.login) },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier
                    .height(Constants.vertSpacerHeight.dp)
                    .fillMaxWidth()
                )

                OutlinedTextField(
                    value = password,
                    singleLine = true,
                    maxLines = 1,
                    textStyle = TextStyle(fontSize = Constants.mediumFontSize.sp),
                    onValueChange = { password = it },
                    label = { Text(text = Constants.password) },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisibility)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff
                        val description = if (passwordVisibility) "Hide password" else "Show password"
                        IconButton(onClick = {
                            passwordVisibility = !passwordVisibility
                        }) {
                            Icon(imageVector = image, description)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier
                    .height(Constants.vertSpacerHeight.dp)
                    .fillMaxWidth()
                )

                Button(onClick = { navController.navigate(Route.MenuScreenRoute.path) }) {
                    Text(text = "Зарегистрироваться", fontSize = Constants.mediumFontSize.sp)
                }

                Spacer(modifier = Modifier
                    .height(Constants.vertSpacerHeight.dp)
                    .fillMaxWidth()
                )

                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Назад", fontSize = Constants.mediumFontSize.sp)
                }

                Spacer(modifier = Modifier
                    .height(Constants.vertSpacerHeight.dp)
                    .fillMaxWidth()
                )
            }
        }
    }
}