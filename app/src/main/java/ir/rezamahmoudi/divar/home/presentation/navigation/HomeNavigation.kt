package ir.rezamahmoudi.divar.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.home.presentation.screen.HomeScreen

fun NavGraphBuilder.homeScreen(
    onNavigateToScreen: (String) -> Unit,
    navigateUp: () -> Unit
) {
    composable(Screen.Home.route) {
        HomeScreen(
            navigateUp = navigateUp,
            onNavigateToScreen = onNavigateToScreen
        )
    }
}
