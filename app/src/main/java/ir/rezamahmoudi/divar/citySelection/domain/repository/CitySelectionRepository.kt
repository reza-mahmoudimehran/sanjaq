package ir.rezamahmoudi.divar.cityselection.domain.repository

import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse

interface CitySelectionRepository {

    suspend fun fetchPlacesList(): Result<PlacesListResponse>
}
