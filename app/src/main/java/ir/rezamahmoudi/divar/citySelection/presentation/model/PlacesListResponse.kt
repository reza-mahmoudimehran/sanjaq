package ir.rezamahmoudi.divar.cityselection.presentation.model

import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.cityselection.data.model.CityDto

@JsonClass(generateAdapter = true)
data class PlacesListResponse(
    val cities: List<CityDto>
)
