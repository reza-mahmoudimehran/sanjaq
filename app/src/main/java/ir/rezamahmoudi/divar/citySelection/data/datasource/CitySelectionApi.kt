package ir.rezamahmoudi.divar.cityselection.data.datasource

import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.data.model.FindCurrentCityBody
import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CitySelectionApi {

    @GET(value = "v1/place/list")
    suspend fun fetchPlacesList(): PlacesListResponse

    @POST(value = "v1/place/find")
    suspend fun findCurrentCity(
        @Body body: FindCurrentCityBody
    ): CityDto
}
