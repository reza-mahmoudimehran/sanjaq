package ir.rezamahmoudi.divar.cityselection.data.datasource

import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import retrofit2.http.GET

interface CitySelectionApi {

    @GET(value = "v1/place/list")
    suspend fun fetchPlacesList(): PlacesListResponse
}
