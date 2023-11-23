package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetPostRowUiModel(
    val data: WidgetPostRowDataUiModel
) : WidgetUiModel {
    companion object {
        val EMPTY = WidgetPostRowUiModel(
            data = WidgetPostRowDataUiModel.EMPTY
        )
    }
}

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
