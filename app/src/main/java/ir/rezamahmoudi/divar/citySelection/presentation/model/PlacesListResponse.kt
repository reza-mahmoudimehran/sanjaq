package ir.rezamahmoudi.divar.citySelection.presentation.model

import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.citySelection.data.model.CityDto

@JsonClass(generateAdapter = true)
data class PlacesListResponse(
    val cities: List<CityDto>
)
