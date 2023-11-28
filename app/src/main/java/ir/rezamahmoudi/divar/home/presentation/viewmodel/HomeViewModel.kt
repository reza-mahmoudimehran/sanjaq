package ir.rezamahmoudi.divar.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezamahmoudi.divar.core.di.qualifiers.IoDispatcher
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDataUiModel
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchPostsUseCase: FetchPostsUseCase,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel(), HomeContract {

    private val _mutableState = MutableStateFlow(HomeContract.State.EMPTY)
    override val state: StateFlow<HomeContract.State> = _mutableState.asStateFlow()

    private val effectChannel = Channel<HomeContract.Effect>(Channel.UNLIMITED)
    override val effect: Flow<HomeContract.Effect> = effectChannel.receiveAsFlow()

    init {
        fetchPosts()
    }

    override fun event(event: HomeContract.Event) {
        when (event) {
            HomeContract.Event.OnBackPressed -> {
                onBackPressed()
            }
        }
    }

    private fun onBackPressed() {
        viewModelScope.launch {
            effectChannel.send(HomeContract.Effect.NavigateUp)
        }
    }
    private fun fetchPosts() {
        viewModelScope.launch {
            fetchPostsUseCase()
                .cachedIn(viewModelScope)
                .flowOn(ioDispatcher)
                .updatePosts()
        }
    }
    private fun Flow<PagingData<WidgetDataUiModel>>.updatePosts() {
        _mutableState.update {
            it.copy(
                posts = this
            )
        }
    }
}
