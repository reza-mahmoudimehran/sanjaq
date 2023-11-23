package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowDataUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetSubTitleRowUiModel

@JsonClass(generateAdapter = true)
data class WidgetSubTitleRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetSubTitleRowDataDto
) : WidgetDto {
    override fun asDomain(): WidgetSubTitleRowUiModel = WidgetSubTitleRowUiModel(
        data = data.asDomain()
    )
}

@JsonClass(generateAdapter = true)
data class WidgetSubTitleRowDataDto(
    val text: String
) : WidgetDataDto {
    override fun asDomain(): WidgetSubTitleRowDataUiModel = WidgetSubTitleRowDataUiModel(
        text = text
    )
}
