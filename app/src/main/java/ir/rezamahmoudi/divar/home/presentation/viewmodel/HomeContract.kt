package ir.rezamahmoudi.divar.home.presentation.viewmodel

import androidx.compose.runtime.Stable
import androidx.paging.PagingData
import ir.rezamahmoudi.divar.core.presentation.model.WidgetUiModel
import ir.rezamahmoudi.divar.core.util.compose.UnidirectionalViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface HomeContract : UnidirectionalViewModel<HomeContract.Event, HomeContract.Effect, HomeContract.State> {

    interface Event

    interface Effect

    @Stable
    data class State(
        val posts: Flow<PagingData<WidgetUiModel>>
    ) {
        companion object {
            val EMPTY = State(
                posts = flowOf(PagingData.empty())
            )
        }
    }
}
