package ir.rezamahmoudi.divar.core.presentation.screen

sealed class Screen(val route: String) {
    object CitySelection : Screen(route = "CitySelection")
}
