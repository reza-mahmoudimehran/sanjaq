package ir.rezamahmoudi.divar.citySelection.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.rezamahmoudi.divar.citySelection.presentation.CitySelectionScreen
import ir.rezamahmoudi.divar.core.presentation.screen.Screen

fun NavGraphBuilder.citySelectionScreen() {
    composable(Screen.CitySelection.route) {
        CitySelectionScreen()
    }
}
