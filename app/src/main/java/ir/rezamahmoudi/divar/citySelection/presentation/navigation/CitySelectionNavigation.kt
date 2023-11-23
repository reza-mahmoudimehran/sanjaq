package ir.rezamahmoudi.divar.cityselection.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.rezamahmoudi.divar.cityselection.presentation.screen.CitySelectionScreen
import ir.rezamahmoudi.divar.core.presentation.screen.Screen

fun NavGraphBuilder.citySelectionScreen(
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    composable(Screen.CitySelection.route) {
        CitySelectionScreen(
            onNavigateToScreen = onNavigateToScreen,
            popBackStack = popBackStack
        )
    }
}
