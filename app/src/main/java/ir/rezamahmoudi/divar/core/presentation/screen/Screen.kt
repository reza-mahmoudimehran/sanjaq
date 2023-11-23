package ir.rezamahmoudi.divar.core.presentation.screen

import ir.rezamahmoudi.divar.core.util.constant.NavArguments.POST_TOKEN_ARGUMENT

sealed class Screen(val route: String) {

    object Splash : Screen(route = "Splash")

    object CitySelection : Screen(route = "CitySelection")

    object Home : Screen(route = "Home")

    object PostDetails : Screen(route = "PostDetails/{$POST_TOKEN_ARGUMENT}") {
        fun createRoute(postToken: String): String {
            return "PostDetails/$postToken"
        }
    }
}
