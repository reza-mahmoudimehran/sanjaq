package ir.rezamahmoudi.divar.postdetails.presentation.viewmodel

import androidx.compose.runtime.Stable
import ir.rezamahmoudi.divar.core.util.compose.UnidirectionalViewModel
import ir.rezamahmoudi.divar.postdetails.presentation.model.PostDetailsUiModel

interface PostDetailsContract :
    UnidirectionalViewModel<PostDetailsContract.Event, PostDetailsContract.Effect, PostDetailsContract.State> {
    interface Event {
        object OnBackPressed : Event
    }

    interface Effect {
        object NavigateUp : Effect
    }

    @Stable
    data class State(
        val postDetails: PostDetailsUiModel
    ) {
        companion object {
            val EMPTY = State(
                postDetails = PostDetailsUiModel.EMPTY
            )
        }
    }
}
