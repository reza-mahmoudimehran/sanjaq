package ir.rezamahmoudi.divar.cityselection.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ir.rezamahmoudi.divar.cityselection.presentation.component.CityItem
import ir.rezamahmoudi.divar.cityselection.presentation.viewmodel.CitySelectionContract
import ir.rezamahmoudi.divar.cityselection.presentation.viewmodel.CitySelectionViewModel
import ir.rezamahmoudi.divar.core.presentation.designsystem.AppTheme
import ir.rezamahmoudi.divar.core.presentation.screen.Screen
import ir.rezamahmoudi.divar.core.util.compose.collectInLaunchedEffect
import ir.rezamahmoudi.divar.core.util.compose.use
import kotlinx.coroutines.InternalCoroutinesApi

@OptIn(InternalCoroutinesApi::class)
@Composable
fun CitySelectionScreen(
    viewModel: CitySelectionViewModel = hiltViewModel(),
    onNavigateToScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    val (state, effect, dispatcher) = use(viewModel = viewModel)

    effect.collectInLaunchedEffect {
        when (it) {
            CitySelectionContract.Effect.PopBackStack -> {
                popBackStack()
            }
            CitySelectionContract.Effect.NavigateToHome -> {
                onNavigateToScreen(Screen.Home.route)
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = AppTheme.dimensions.mainContentPadding)
            .fillMaxSize()
    ) {
        items(items = state.cities, key = { it.id }) { city ->
            CityItem(
                city = city,
                onSelectCity = {
                    dispatcher.invoke(CitySelectionContract.Event.OnSelectCity(it))
                }
            )
        }
    }
}
