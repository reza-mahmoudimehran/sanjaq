package ir.rezamahmoudi.divar.postdetails.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.core.util.constant.NavArguments.POST_TOKEN_ARGUMENT
import ir.rezamahmoudi.divar.postdetails.presentation.screen.PostDetailsScreen

fun NavGraphBuilder.postDetailsScreen(
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    composable(
        route = Screen.PostDetails.route,
        arguments = listOf(
            navArgument(name = POST_TOKEN_ARGUMENT) {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            }
        )
    ) {
        PostDetailsScreen(
            popBackStack = popBackStack,
            onNavigateToScreen = onNavigateToScreen
        )
    }
}
