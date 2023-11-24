package ir.rezamahmoudi.divar.cityselection.domain.usecase

import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import ir.rezamahmoudi.divar.core.util.mapper.asDomain
import javax.inject.Inject

class FindCurrentCityUseCase @Inject constructor(
    private val repository: CitySelectionRepository
) {
    suspend operator fun invoke(lat: Double, long: Double): Result<CityUiModel> =
        repository.findCurrentCity(params = FindCurrentCityParams(lat = lat, long = long)).map { it.asDomain() }
}

data class FindCurrentCityParams(
    val lat: Double,
    val long: Double
)
