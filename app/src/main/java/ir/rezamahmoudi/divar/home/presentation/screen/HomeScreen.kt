package ir.rezamahmoudi.divar.home.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import ir.rezamahmoudi.divar.R
import ir.rezamahmoudi.divar.core.presentation.component.widget.WidgetItem
import ir.rezamahmoudi.divar.core.presentation.widget.navbar.NavBar
import ir.rezamahmoudi.divar.core.util.compose.collectInLaunchedEffect
import ir.rezamahmoudi.divar.core.util.compose.use
import ir.rezamahmoudi.divar.home.presentation.viewmodel.HomeContract
import ir.rezamahmoudi.divar.home.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    navigateUp: () -> Unit
) {
    val (state, effect, dispatcher) = use(viewModel = viewModel)

    effect.collectInLaunchedEffect {
        when (it) {
            HomeContract.Effect.NavigateUp -> {
                navigateUp()
            }
        }
    }
    val posts = state.posts.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            NavBar(
                text = stringResource(id = R.string.post_list_title),
                navigateUp = {
                    dispatcher(HomeContract.Event.OnBackPressed)
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
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
}
