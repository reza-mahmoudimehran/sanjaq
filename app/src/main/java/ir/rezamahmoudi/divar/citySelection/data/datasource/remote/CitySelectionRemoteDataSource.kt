package ir.rezamahmoudi.divar.cityselection.data.datasource.remote

import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FindCurrentCityParams

interface CitySelectionRemoteDataSource {

    suspend fun fetchPlacesList(): Result<PlacesListResponse>

    suspend fun findCurrentCity(params: FindCurrentCityParams): Result<CityDto>
}
