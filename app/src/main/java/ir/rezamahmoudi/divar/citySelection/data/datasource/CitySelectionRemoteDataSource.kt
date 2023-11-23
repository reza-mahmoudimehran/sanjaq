package ir.rezamahmoudi.divar.citySelection.data.datasource

import ir.rezamahmoudi.divar.citySelection.presentation.model.PlacesListResponse

interface CitySelectionRemoteDataSource {

    suspend fun fetchPlacesList(): Result<PlacesListResponse>
}
