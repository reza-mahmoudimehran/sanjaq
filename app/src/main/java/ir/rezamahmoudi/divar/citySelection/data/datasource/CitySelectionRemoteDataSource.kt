package ir.rezamahmoudi.divar.cityselection.data.datasource

import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse

interface CitySelectionRemoteDataSource {

    suspend fun fetchPlacesList(): Result<PlacesListResponse>
}
