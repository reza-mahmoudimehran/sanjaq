package ir.rezamahmoudi.divar.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.home.presentation.HomeScreen

fun NavGraphBuilder.homeScreen(
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    composable(Screen.Splash.route) {
        HomeScreen(
            popBackStack = popBackStack,
            onNavigateToScreen = onNavigateToScreen
        )
    }
}
