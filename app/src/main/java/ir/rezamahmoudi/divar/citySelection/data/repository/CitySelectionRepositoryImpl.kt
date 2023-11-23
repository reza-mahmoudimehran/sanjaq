package ir.rezamahmoudi.divar.citySelection.data.repository

import ir.rezamahmoudi.divar.citySelection.data.datasource.CitySelectionRemoteDataSource
import ir.rezamahmoudi.divar.citySelection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.citySelection.presentation.model.PlacesListResponse
import javax.inject.Inject

class CitySelectionRepositoryImpl @Inject constructor(
    private val remoteDataSource: CitySelectionRemoteDataSource
) : CitySelectionRepository {
    override suspend fun fetchPlacesList(): Result<PlacesListResponse> = remoteDataSource.fetchPlacesList()
}
