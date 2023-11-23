package ir.rezamahmoudi.divar.cityselection.data.model

import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.cityselection.presentation.model.CentroidUiModel
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import ir.rezamahmoudi.divar.core.data.model.Dto

@JsonClass(generateAdapter = true)
data class CityDto(
    val id: Int,
    val name: String,
    val slug: String,
    val radius: Int,
    val centroid: CentroidDto
) : Dto<CityUiModel> {
    override fun asDomain(): CityUiModel = CityUiModel(
        id = id,
        name = name,
        slug = slug,
        radius = radius,
        centroid = centroid.asDomain()
    )
}

@JsonClass(generateAdapter = true)
data class CentroidDto(
    val latitude: String,
    val longitude: String
) : Dto<CentroidUiModel> {
    override fun asDomain(): CentroidUiModel = CentroidUiModel(
        latitude = latitude,
        longitude = longitude
    )
}
