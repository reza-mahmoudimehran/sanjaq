package ir.rezamahmoudi.divar.cityselection.domain.usecase

import ir.rezamahmoudi.divar.core.domain.datastore.DataStoreRepository
import ir.rezamahmoudi.divar.core.domain.datastore.preferences.PreferencesKeys
import javax.inject.Inject

class SaveDefaultCityIdUseCase @Inject constructor(
    private val repository: DataStoreRepository
) {
    suspend operator fun invoke(defaultCityId: String) =
        repository.save(key = PreferencesKeys.defaultCityId, value = defaultCityId)
}
