package com.team.whackamole.ui


sealed class Route(val path: String) {
    object MenuScreenRoute : Route("menu_screen_route/")
    object SplashScreenRoute : Route("splash_screen_route/")
    object GameScreen : Route("game_screen_route/")
    object ResultScreen : Route("result_screen_route/")
    object AuthScreen : Route("auth_screen_route/")
    object RegistrationScreen : Route("registration_screen_route/")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}