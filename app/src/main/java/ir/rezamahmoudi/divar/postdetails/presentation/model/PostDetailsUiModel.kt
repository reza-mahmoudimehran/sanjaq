package ir.rezamahmoudi.divar.postdetails.presentation.model

import androidx.compose.runtime.Stable
import ir.rezamahmoudi.divar.core.data.model.Domain
import ir.rezamahmoudi.divar.core.presentation.model.WidgetUiModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Stable
data class PostDetailsUiModel(
    val widgets: ImmutableList<WidgetUiModel>,
    val enableContact: Boolean,
    val contactButtonText: String
) : Domain {
    companion object {
        val EMPTY = PostDetailsUiModel(
            widgets = persistentListOf(),
            enableContact = true,
            contactButtonText = ""
        )
    }
}
