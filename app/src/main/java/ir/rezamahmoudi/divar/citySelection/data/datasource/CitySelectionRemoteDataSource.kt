package ir.rezamahmoudi.divar.cityselection.data.datasource

import ir.rezamahmoudi.divar.cityselection.presentation.model.PlacesListResponse

interface CitySelectionRemoteDataSource {

    suspend fun fetchPlacesList(): Result<PlacesListResponse>
}
