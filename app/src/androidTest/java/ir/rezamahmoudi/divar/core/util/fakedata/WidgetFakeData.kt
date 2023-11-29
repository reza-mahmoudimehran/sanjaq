package ir.rezamahmoudi.divar.core.util.fakedata

import ir.rezamahmoudi.divar.core.data.model.widget.WidgetPostRowDataDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetPostRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetTitleRowDataDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetTitleRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetType
import ir.rezamahmoudi.divar.home.data.entity.WidgetEntity

val WIDGET_TITLE_ROW_DTO_TEST_OBJECT = WidgetTitleRowDto(
    widgetType = WidgetType.TITLE_ROW.name,
    data = WidgetTitleRowDataDto(
        text = "text"
    )
)

val WIDGET_POST_ROW_DTO_TEST_OBJECT_1 = WidgetPostRowDto(
    widgetType = WidgetType.POST_ROW.name,
    data = WidgetPostRowDataDto(
        title = "title1",
        token = "token1",
        price = "price1",
        thumbnail = "thumbnail1",
        district = "district1"
    )
)

val WIDGET_POST_ROW_DTO_TEST_OBJECT_2 = WidgetPostRowDto(
    widgetType = WidgetType.POST_ROW.name,
    data = WidgetPostRowDataDto(
        title = "title2",
        token = "token2",
        price = "price2",
        thumbnail = "thumbnail2",
        district = "district2"
    )
)

val WIDGET_POST_ROW_DTO_TEST_OBJECT_3 = WidgetPostRowDto(
    widgetType = WidgetType.POST_ROW.name,
    data = WidgetPostRowDataDto(
        title = "title3",
        token = "token3",
        price = "price3",
        thumbnail = "thumbnail3",
        district = "district3"
    )
)

val WIDGET_ENTITY_TEST_OBJECT_1 = WidgetEntity(
    widgetDto = WIDGET_TITLE_ROW_DTO_TEST_OBJECT,
    cityId = 1
)
val WIDGET_ENTITY_TEST_OBJECT_2 = WidgetEntity(
    widgetDto = WIDGET_POST_ROW_DTO_TEST_OBJECT_1,
    cityId = 1
)
val WIDGET_ENTITY_TEST_OBJECT_3 = WidgetEntity(
    widgetDto = WIDGET_POST_ROW_DTO_TEST_OBJECT_2,
    cityId = 1
)
val WIDGET_ENTITY_TEST_OBJECT_4 = WidgetEntity(
    widgetDto = WIDGET_POST_ROW_DTO_TEST_OBJECT_3,
    cityId = 1
)
