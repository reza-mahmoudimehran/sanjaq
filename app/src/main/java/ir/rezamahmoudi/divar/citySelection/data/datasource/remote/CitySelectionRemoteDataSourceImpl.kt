package ir.rezamahmoudi.divar.cityselection.data.datasource.remote

import ir.rezamahmoudi.divar.cityselection.data.model.CityDto
import ir.rezamahmoudi.divar.cityselection.data.model.FindCurrentCityBody
import ir.rezamahmoudi.divar.cityselection.data.model.PlacesListResponse
import ir.rezamahmoudi.divar.cityselection.domain.usecase.FindCurrentCityParams
import javax.inject.Inject

class CitySelectionRemoteDataSourceImpl @Inject constructor(
    private val api: CitySelectionApi
) : CitySelectionRemoteDataSource {
    override suspend fun fetchPlacesList(): Result<PlacesListResponse> =
        runCatching { api.fetchPlacesList() }

    override suspend fun findCurrentCity(params: FindCurrentCityParams): Result<CityDto> =
        runCatching {
            api.findCurrentCity(
                FindCurrentCityBody(
                    lat = params.lat,
                    long = params.long
                )
            )
        }
}
