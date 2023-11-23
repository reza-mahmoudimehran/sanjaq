package ir.rezamahmoudi.divar.citySelection.domain.repository

import ir.rezamahmoudi.divar.citySelection.presentation.model.PlacesListResponse

interface CitySelectionRepository {

    suspend fun fetchPlacesList(): Result<PlacesListResponse>
}
