package ir.rezamahmoudi.divar.cityselection.domain.repository

import ir.rezamahmoudi.divar.cityselection.data.entity.CitiesEntity
import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FindCurrentCityParams

interface CitySelectionRepository {

    suspend fun fetchPlacesList(): Result<PlacesListResponse>

    suspend fun findCurrentCity(params: FindCurrentCityParams): Result<CityDto>

    suspend fun getAllCities(): Result<List<CitiesEntity>>

    suspend fun insertCities(cities: List<CitiesEntity>): Result<Unit>
}
