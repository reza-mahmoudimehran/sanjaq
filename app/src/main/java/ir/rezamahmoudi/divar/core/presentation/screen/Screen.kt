package ir.rezamahmoudi.divar.core.presentation.screen

sealed class Screen(val route: String) {
    object Splash : Screen(route = "Splash")
    object CitySelection : Screen(route = "CitySelection")
}
