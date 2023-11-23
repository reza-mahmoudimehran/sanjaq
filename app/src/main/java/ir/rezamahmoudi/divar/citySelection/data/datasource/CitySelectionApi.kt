package ir.rezamahmoudi.divar.citySelection.data.datasource

import ir.rezamahmoudi.divar.citySelection.presentation.model.PlacesListResponse
import retrofit2.http.GET

interface CitySelectionApi {

    @GET(value = "v1/place/list")
    suspend fun fetchPlacesList(): PlacesListResponse
}
