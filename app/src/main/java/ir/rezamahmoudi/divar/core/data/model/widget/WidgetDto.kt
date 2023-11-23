package ir.rezamahmoudi.divar.core.data.model.widget

import ir.rezamahmoudi.divar.core.data.model.Dto
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDataUiModel

interface WidgetDto {
    val widgetType: String
    val data: WidgetDataDto
}

interface WidgetDataDto : Dto<WidgetDataUiModel>

enum class WidgetType {
    TITLE_ROW,
    SUBTITLE_ROW,
    POST_ROW,
    HEADER_ROW,
    INFO_ROW,
    DESCRIPTION_ROW,
    IMAGE_SLIDER_ROW
}
