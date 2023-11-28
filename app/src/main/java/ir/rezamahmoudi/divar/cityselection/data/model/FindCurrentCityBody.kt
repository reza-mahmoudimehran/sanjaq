package ir.rezamahmoudi.divar.cityselection.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FindCurrentCityBody(
    val lat: Double,
    val long: Double
)
