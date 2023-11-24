package ir.rezamahmoudi.divar.cityselection.data.repository

import ir.rezamahmoudi.divar.cityselection.data.datasource.CitySelectionRemoteDataSource
import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FindCurrentCityParams
import javax.inject.Inject

class CitySelectionRepositoryImpl @Inject constructor(
    private val remoteDataSource: CitySelectionRemoteDataSource
) : CitySelectionRepository {
    override suspend fun fetchPlacesList(): Result<PlacesListResponse> = remoteDataSource.fetchPlacesList()

    override suspend fun findCurrentCity(params: FindCurrentCityParams): Result<CityDto> =
        remoteDataSource.findCurrentCity(params = params)
}
