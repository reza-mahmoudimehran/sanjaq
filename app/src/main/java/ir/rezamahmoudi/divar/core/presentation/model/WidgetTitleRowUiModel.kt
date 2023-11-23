package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetTitleRowUiModel(
    val data: WidgetTitleRowDataUiModel
) : WidgetUiModel

@Stable
data class WidgetTitleRowDataUiModel(
    val text: String
) : WidgetDataUiModel
