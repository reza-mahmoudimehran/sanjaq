package ir.rezamahmoudi.divar.home.data.mappers

import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.home.data.entity.WidgetEntity

fun List<WidgetDto>.mapToEntity(cityId: Int): List<WidgetEntity> = map {
    WidgetEntity(
        cityId = cityId,
        widgetDto = it
    )
}
