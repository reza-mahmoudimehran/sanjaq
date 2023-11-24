package ir.rezamahmoudi.divar.postdetails.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ir.rezamahmoudi.divar.core.presentation.component.widget.WidgetItem
import ir.rezamahmoudi.divar.core.util.compose.collectInLaunchedEffect
import ir.rezamahmoudi.divar.core.util.compose.use
import ir.rezamahmoudi.divar.postdetails.presentation.viewmodel.PostDetailsViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class)
@Composable
fun PostDetailsScreen(
    viewModel: PostDetailsViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    val (state, effect, dispatcher) = use(viewModel = viewModel)

    effect.collectInLaunchedEffect {
        when (it) {
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = state.postDetails.widgets) {
            WidgetItem(
                widget = it,
                onNavigateToScreen = onNavigateToScreen
            )
        }
    }
}
