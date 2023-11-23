package ir.rezamahmoudi.divar.home.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import ir.rezamahmoudi.divar.core.domain.datastore.DataStoreRepository
import ir.rezamahmoudi.divar.core.domain.datastore.preferences.PreferencesKeys
import ir.rezamahmoudi.divar.core.presentation.model.WidgetDataUiModel
import ir.rezamahmoudi.divar.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FetchPostsUseCase @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val repository: HomeRepository
) {
    suspend operator fun invoke(): Flow<PagingData<WidgetDataUiModel>> {
        val selectedCityId = dataStoreRepository.read(PreferencesKeys.selectedCityId).first() ?: "1"

        return repository.fetchPosts(params = FetchPostsParams(selectedCityId = selectedCityId))
            .map { it.map { widget -> widget.data.asDomain() } }
    }
}

data class FetchPostsParams(
    val selectedCityId: String
)
