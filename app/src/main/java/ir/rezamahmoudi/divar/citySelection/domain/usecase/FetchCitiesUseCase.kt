package ir.rezamahmoudi.divar.cityselection.domain.usecase

import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import ir.rezamahmoudi.divar.core.util.mapper.asDomain
import kotlinx.collections.immutable.ImmutableList
import javax.inject.Inject

class FetchCitiesUseCase @Inject constructor(
    private val repository: CitySelectionRepository
) {
    suspend operator fun invoke(): Result<ImmutableList<CityUiModel>> =
        repository.fetchPlacesList().map { it.cities.asDomain() }
}
