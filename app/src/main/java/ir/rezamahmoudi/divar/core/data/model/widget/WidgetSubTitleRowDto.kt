package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowDataUiModel

@JsonClass(generateAdapter = true)
data class WidgetSubTitleRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetSubTitleRowDataDto
) : WidgetDto

@JsonClass(generateAdapter = true)
data class WidgetSubTitleRowDataDto(
    val text: String
) : WidgetDataDto {
    override fun asDomain(): WidgetSubTitleRowDataUiModel = WidgetSubTitleRowDataUiModel(
        text = text
    )
}
