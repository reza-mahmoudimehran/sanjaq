package ir.rezamahmoudi.divar.core.util.fakedata

import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDescriptionRowDataDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDescriptionRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetHeaderRowDataDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetHeaderRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetTitleRowDataDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetTitleRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetType

val WIDGET_TITLE_ROW_DTO_TEST_OBJECT = WidgetTitleRowDto(
    widgetType = WidgetType.TITLE_ROW.name,
    data = WidgetTitleRowDataDto(
        text = "text"
    )
)

val WIDGET_HEADER_ROW_DTO_TEST_OBJECT = WidgetHeaderRowDto(
    widgetType = WidgetType.HEADER_ROW.name,
    data = WidgetHeaderRowDataDto(
        title = "title",
        subtitle = "subtitle"
    )
)

val WIDGET_DESCRIPTION_ROW_DTO_TEST_OBJECT = WidgetDescriptionRowDto(
    widgetType = WidgetType.DESCRIPTION_ROW.name,
    data = WidgetDescriptionRowDataDto(
        text = "text"
    )
)
