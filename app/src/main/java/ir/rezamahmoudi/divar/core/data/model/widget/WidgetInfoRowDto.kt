package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.presentation.model.WidgetInfoRowDataUiModel

@JsonClass(generateAdapter = true)
data class WidgetInfoRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetInfoRowDataDto
) : WidgetDto

@JsonClass(generateAdapter = true)
data class WidgetInfoRowDataDto(
    val title: String,
    val value: String
) : WidgetDataDto {
    override fun asDomain(): WidgetInfoRowDataUiModel = WidgetInfoRowDataUiModel(
        title = title,
        value = value
    )
}
