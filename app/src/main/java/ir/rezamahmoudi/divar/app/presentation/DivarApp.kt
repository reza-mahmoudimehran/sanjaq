package ir.rezamahmoudi.divar.app.presentation

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ir.rezamahmoudi.divar.cityselection.presentation.navigation.citySelectionScreen
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.home.presentation.navigation.homeScreen
import ir.rezamahmoudi.divar.postdetails.presentation.navigation.postDetailsScreen
import ir.rezamahmoudi.divar.splash.presentation.navigation.splashScreen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DivarApp() {
    Scaffold(
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
        DivarNavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)
                )
        )
    }
}

@Composable
fun DivarNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Splash.route
) {
    val navController = rememberNavController()

    val onNavigateToScreen = { route: String -> navController.navigate(route) }
    val popBackStack: () -> Unit = { navController.popBackStack() }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        splashScreen(
            onNavigateToScreen = onNavigateToScreen,
            popBackStack = popBackStack
        )

        citySelectionScreen(
            onNavigateToScreen = onNavigateToScreen,
            popBackStack = popBackStack
        )

        homeScreen(
            onNavigateToScreen = onNavigateToScreen,
            popBackStack = popBackStack
        )

        postDetailsScreen(
            onNavigateToScreen = onNavigateToScreen,
            popBackStack = popBackStack
        )
    }
}
