package ir.rezamahmoudi.divar.cityselection.data.repository

import ir.rezamahmoudi.divar.cityselection.data.datasource.local.CitySelectionLocalDataSourceImpl
import ir.rezamahmoudi.divar.cityselection.data.datasource.remote.CitySelectionRemoteDataSource
import ir.rezamahmoudi.divar.cityselection.data.entity.CitiesEntity
import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FindCurrentCityParams
import javax.inject.Inject

class CitySelectionRepositoryImpl @Inject constructor(
    private val localDataSourceImpl: CitySelectionLocalDataSourceImpl,
    private val remoteDataSource: CitySelectionRemoteDataSource
) : CitySelectionRepository {
    override suspend fun fetchPlacesList(): Result<PlacesListResponse> = remoteDataSource.fetchPlacesList()

    override suspend fun findCurrentCity(params: FindCurrentCityParams): Result<CityDto> =
        remoteDataSource.findCurrentCity(params = params)

    override suspend fun getAllCities(): Result<List<CitiesEntity>> =
        localDataSourceImpl.getAllCities()

    override suspend fun insertCities(cities: List<CitiesEntity>): Result<Unit> =
        localDataSourceImpl.insertCities(cities = cities)
}
