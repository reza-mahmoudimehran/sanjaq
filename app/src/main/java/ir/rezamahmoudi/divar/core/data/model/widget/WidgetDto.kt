package ir.rezamahmoudi.divar.core.data.model.widget

import ir.rezamahmoudi.divar.core.data.model.Dto
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetUiModel

interface WidgetDto : Dto<WidgetUiModel> {
    val widgetType: String
    val data: WidgetDataDto
}

interface WidgetDataDto : Dto<WidgetDataUiModel>

enum class WidgetType {
    TITLE_ROW,
    SUBTITLE_ROW,
    POST_ROW
}
