package ir.rezamahmoudi.divar.postdetails.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.rezamahmoudi.divar.core.util.constant.NavArguments.POST_TOKEN_ARGUMENT
import ir.rezamahmoudi.divar.postdetails.domain.usecase.FetchPostDetailsUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(
    private val fetchPostDetailsUseCase: FetchPostDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(), PostDetailsContract {

    private val _mutableState = MutableStateFlow(PostDetailsContract.State.EMPTY)
    override val state: StateFlow<PostDetailsContract.State> = _mutableState.asStateFlow()

    private val effectChannel = Channel<PostDetailsContract.Effect>(Channel.UNLIMITED)
    override val effect: Flow<PostDetailsContract.Effect> = effectChannel.receiveAsFlow()

    private val postToken = savedStateHandle.get<String>(POST_TOKEN_ARGUMENT)

    init {
        fetchPostDetails()
    }

    override fun event(event: PostDetailsContract.Event) {
        when (event) {
            PostDetailsContract.Event.OnBackPressed -> {
                onBackPressed()
            }
        }
    }

    private fun onBackPressed() {
        viewModelScope.launch {
            effectChannel.send(PostDetailsContract.Effect.NavigateUp)
        }
    }

    private fun fetchPostDetails() {
        viewModelScope.launch {
            postToken?.let { token ->
                fetchPostDetailsUseCase(postToken = token).onSuccess { postDetails ->
                    _mutableState.update { it.copy(postDetails = postDetails) }
                }
            }
        }
    }
}
