package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetPostRowDataUiModel(
    val title: String,
    val token: String,
    val price: String,
    val thumbnail: String,
    val district: String
) : WidgetDataUiModel {
    companion object {
        val EMPTY = WidgetPostRowDataUiModel(
            title = "",
            token = "",
            price = "",
            thumbnail = "",
            district = ""
        )
    }
}
