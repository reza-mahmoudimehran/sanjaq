package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.presentation.model.WidgetPostRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetPostRowUiModel

@JsonClass(generateAdapter = true)
data class WidgetPostRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetPostRowDataDto
) : WidgetDto {
    override fun asDomain(): WidgetPostRowUiModel = WidgetPostRowUiModel(
        data = data.asDomain()
    )
}

@JsonClass(generateAdapter = true)
data class WidgetPostRowDataDto(
    val title: String,
    val token: String,
    val price: String,
    val thumbnail: String,
    val district: String
) : WidgetDataDto {
    override fun asDomain(): WidgetPostRowDataUiModel = WidgetPostRowDataUiModel(
        title = title,
        token = token,
        price = price,
        thumbnail = thumbnail,
        district = district
    )
}
