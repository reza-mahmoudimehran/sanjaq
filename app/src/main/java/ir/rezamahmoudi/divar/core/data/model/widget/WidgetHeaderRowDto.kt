package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.presentation.model.WidgetHeaderRowDataUiModel

@JsonClass(generateAdapter = true)
data class WidgetHeaderRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetHeaderRowDataDto
) : WidgetDto

@JsonClass(generateAdapter = true)
data class WidgetHeaderRowDataDto(
    val title: String,
    val subtitle: String?
) : WidgetDataDto {
    override fun asDomain(): WidgetHeaderRowDataUiModel = WidgetHeaderRowDataUiModel(
        title = title,
        subtitle = subtitle
    )
}
