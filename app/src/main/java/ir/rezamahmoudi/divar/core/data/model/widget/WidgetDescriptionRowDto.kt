package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDescriptionRowDataUiModel

@JsonClass(generateAdapter = true)
data class WidgetDescriptionRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetDescriptionRowDataDto
) : WidgetDto

@JsonClass(generateAdapter = true)
data class WidgetDescriptionRowDataDto(
    val text: String
) : WidgetDataDto {
    override fun asDomain(): WidgetDescriptionRowDataUiModel = WidgetDescriptionRowDataUiModel(
        text = text
    )
}
