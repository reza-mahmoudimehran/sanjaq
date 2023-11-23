package ir.rezamahmoudi.divar.home.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ir.rezamahmoudi.divar.core.presentation.component.widget.WidgetItem
import ir.rezamahmoudi.divar.core.util.compose.collectInLaunchedEffect
import ir.rezamahmoudi.divar.core.util.compose.use
import ir.rezamahmoudi.divar.home.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    val (state, effect, dispatcher) = use(viewModel = viewModel)

    effect.collectInLaunchedEffect {
        when (it) { }
    }
    val posts = state.posts.collectAsLazyPagingItems()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(posts.itemCount) { index ->
            posts[index]?.let {
                WidgetItem(
                    widget = it,
                    onNavigateToScreen = onNavigateToScreen
                )
            }
        }
    }
}
