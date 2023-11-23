package ir.rezamahmoudi.divar.core.data.model.widget

import ir.rezamahmoudi.divar.core.data.model.Dto
import ir.rezamahmoudi.divar.core.presentation.model.WidgetUiModel

sealed class WidgetDto : Dto<WidgetUiModel> {
    abstract val widgetType: String
}
