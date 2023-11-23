package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetPostRowUiModel(
    val data: WidgetPostRowDataUiModel
) : WidgetUiModel

@Stable
data class WidgetPostRowDataUiModel(
    val title: String,
    val token: String,
    val price: String,
    val thumbnail: String,
    val district: String
) : WidgetDataUiModel
