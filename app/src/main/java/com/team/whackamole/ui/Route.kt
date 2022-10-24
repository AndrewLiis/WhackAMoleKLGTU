package com.team.whackamole.ui

sealed class Route(val path: String) {
    object MenuScreenRoute : Route("menu_screen_route/")
    object SplashScreenRoute : Route("splash_screen_route/")
}