package ir.rezamahmoudi.divar.cityselection.data.repository

import ir.rezamahmoudi.divar.cityselection.data.datasource.CitySelectionRemoteDataSource
import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.cityselection.presentation.model.PlacesListResponse
import javax.inject.Inject

class CitySelectionRepositoryImpl @Inject constructor(
    private val remoteDataSource: CitySelectionRemoteDataSource
) : CitySelectionRepository {
    override suspend fun fetchPlacesList(): Result<PlacesListResponse> = remoteDataSource.fetchPlacesList()
}
