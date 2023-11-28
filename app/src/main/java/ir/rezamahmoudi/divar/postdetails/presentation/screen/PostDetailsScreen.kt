package ir.rezamahmoudi.divar.postdetails.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import ir.rezamahmoudi.divar.R
import ir.rezamahmoudi.divar.core.presentation.component.widget.WidgetItem
import ir.rezamahmoudi.divar.core.presentation.widget.navbar.NavBar
import ir.rezamahmoudi.divar.core.util.compose.collectInLaunchedEffect
import ir.rezamahmoudi.divar.core.util.compose.use
import ir.rezamahmoudi.divar.postdetails.presentation.viewmodel.PostDetailsContract
import ir.rezamahmoudi.divar.postdetails.presentation.viewmodel.PostDetailsViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(
    InternalCoroutinesApi::class,
    ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun PostDetailsScreen(
    viewModel: PostDetailsViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    navigateUp: () -> Unit
) {
    val (state, effect, dispatcher) = use(viewModel = viewModel)

    effect.collectInLaunchedEffect {
        when (it) {
            PostDetailsContract.Effect.NavigateUp -> {
                navigateUp()
            }
        }
    }

    Scaffold(
        topBar = {
            NavBar(
                text = stringResource(id = R.string.post_details_title),
                navigateUp = {
                    dispatcher(PostDetailsContract.Event.OnBackPressed)
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
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
}
