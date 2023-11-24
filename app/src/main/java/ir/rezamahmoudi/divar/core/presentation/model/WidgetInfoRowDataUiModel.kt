package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetInfoRowDataUiModel(
    val title: String,
    val value: String
) : WidgetDataUiModel
