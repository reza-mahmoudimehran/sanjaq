package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.presentation.model.WidgetTitleRowDataUiModel

@JsonClass(generateAdapter = true)
data class WidgetTitleRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetTitleRowDataDto
) : WidgetDto

@JsonClass(generateAdapter = true)
data class WidgetTitleRowDataDto(
    val text: String
) : WidgetDataDto {
    override fun asDomain(): WidgetTitleRowDataUiModel = WidgetTitleRowDataUiModel(
        text = text
    )
}
