package com.team.whackamole.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.team.whackamole.ui.Route
import com.team.whackamole.ui.screens.MenuScreen
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
    }
}
