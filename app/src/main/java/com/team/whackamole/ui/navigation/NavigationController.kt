package com.team.whackamole.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.team.whackamole.ui.Route
import com.team.whackamole.ui.screens.GameScreen
import com.team.whackamole.ui.screens.MenuScreen
import com.team.whackamole.ui.screens.ResultScreen
import com.team.whackamole.ui.screens.SplashScreen

@Composable
fun NavigationController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.SplashScreenRoute.path) {
        composable(route = Route.SplashScreenRoute.path) {
            SplashScreen(navController = navController)
        }
        composable(route = Route.MenuScreenRoute.path) {
            MenuScreen(navController = navController)
        }
        composable(route = Route.GameScreen.path) {
            GameScreen(navController = navController)
        }
        composable(
            route = Route.ResultScreen.path + "/{score}",
            arguments = listOf(
                navArgument("score") {
                    type = NavType.StringType
                    defaultValue = "Что-то пошло не так"
                    nullable = true
                }
            )
        ) { entry ->
            ResultScreen(navController = navController, score = entry.arguments?.getString("score"))
        }
    }
}
