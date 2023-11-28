package ir.rezamahmoudi.divar.cityselection.domain.usecase

import ir.rezamahmoudi.divar.cityselection.data.mappers.asDomain
import ir.rezamahmoudi.divar.cityselection.data.mappers.mapToEntity
import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository
import ir.rezamahmoudi.divar.cityselection.presentation.model.CityUiModel
import ir.rezamahmoudi.divar.core.util.mapper.asDomain
import ir.rezamahmoudi.divar.core.util.network.connection.NetworkConnection
import ir.rezamahmoudi.divar.postdetails.data.mappers.asDomain
import ir.rezamahmoudi.divar.postdetails.data.mappers.mapToEntity
import kotlinx.collections.immutable.ImmutableList
import javax.inject.Inject

class FetchCitiesUseCase @Inject constructor(
    private val repository: CitySelectionRepository,
    private val networkConnection: NetworkConnection
) {
    suspend operator fun invoke(): Result<ImmutableList<CityUiModel>> =
        if (networkConnection.isConnected()) {
            repository.fetchPlacesList()
                .onSuccess { repository.insertCities(it.cities.mapToEntity()) }
                .map { it.cities.asDomain() }
        } else {
            repository.getAllCities().map { it.asDomain() }
        }
}
