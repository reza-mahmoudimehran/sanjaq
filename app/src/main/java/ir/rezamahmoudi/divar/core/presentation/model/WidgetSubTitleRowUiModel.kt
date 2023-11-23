package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetSubTitleRowUiModel(
    val data: WidgetSubTitleRowDataUiModel
) : WidgetUiModel

@Stable
data class WidgetSubTitleRowDataUiModel(
    val text: String
) : WidgetDataUiModel
