package ir.rezamahmoudi.divar.splash.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.splash.presentation.SplashScreen

fun NavGraphBuilder.splashScreen(
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    composable(Screen.Splash.route) {
        SplashScreen(
            popBackStack = popBackStack,
            onNavigateToScreen = onNavigateToScreen
        )
    }
}
