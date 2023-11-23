package ir.rezamahmoudi.divar.cityselection.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlacesListResponse(
    val cities: List<CityDto>
)
