package ir.rezamahmoudi.divar.core.data.model.widget

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.data.model.Dto
import ir.rezamahmoudi.divar.core.presentation.model.ImageSliderItemUiModel
import ir.rezamahmoudi.divar.core.presentation.model.WidgetImageSliderRowDataUiModel
import ir.rezamahmoudi.divar.core.util.mapper.asDomain

@JsonClass(generateAdapter = true)
data class WidgetImageSliderRowDto(
    @Json(name = "widget_type") override val widgetType: String,
    override val data: WidgetImageSliderRowDataDto
) : WidgetDto

@JsonClass(generateAdapter = true)
data class WidgetImageSliderRowDataDto(
    val items: List<ImageSliderItemDto>
) : WidgetDataDto {
    override fun asDomain(): WidgetImageSliderRowDataUiModel = WidgetImageSliderRowDataUiModel(
        items = items.asDomain()
    )
}

@JsonClass(generateAdapter = true)
data class ImageSliderItemDto(
    @Json(name = "image_url") val imageUrl: String
) : Dto<ImageSliderItemUiModel> {
    override fun asDomain(): ImageSliderItemUiModel = ImageSliderItemUiModel(
        imageUrl = imageUrl
    )
}
