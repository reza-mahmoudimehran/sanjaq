package ir.rezamahmoudi.divar.core.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class WidgetHeaderRowDataUiModel(
    val title: String,
    val subtitle: String?
) : WidgetDataUiModel
