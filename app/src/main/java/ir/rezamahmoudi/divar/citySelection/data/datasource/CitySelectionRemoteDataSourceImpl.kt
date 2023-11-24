package ir.rezamahmoudi.divar.cityselection.data.datasource

import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import javax.inject.Inject

class CitySelectionRemoteDataSourceImpl @Inject constructor(
    private val api: CitySelectionApi
) : CitySelectionRemoteDataSource {
    override suspend fun fetchPlacesList(): Result<PlacesListResponse> = runCatching { api.fetchPlacesList() }
}
