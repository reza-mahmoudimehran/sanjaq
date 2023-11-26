package ir.rezamahmoudi.divar.postdetails.domain.usecase

import ir.rezamahmoudi.divar.core.util.network.connection.NetworkConnection
import ir.rezamahmoudi.divar.postdetails.data.mappers.asDomain
import ir.rezamahmoudi.divar.postdetails.data.mappers.mapToEntity
import ir.rezamahmoudi.divar.postdetails.domain.repository.PostDetailsRepository
import ir.rezamahmoudi.divar.postdetails.presentation.model.PostDetailsUiModel
import javax.inject.Inject

class FetchPostDetailsUseCase @Inject constructor(
    private val repository: PostDetailsRepository,
    private val networkConnection: NetworkConnection
) {
    suspend operator fun invoke(postToken: String): Result<PostDetailsUiModel> =
        if (networkConnection.isConnected()) {
            repository.fetchPostDetails(params = FetchPostDetailsParams(postToken = postToken))
                .onSuccess { repository.insertPostDetails(it.mapToEntity(postToken = postToken)) }
                .map { it.asDomain() }
        } else {
            repository.getCachedPostDetails(postToken = postToken).map { it.asDomain() }
        }
}

data class FetchPostDetailsParams(
    val postToken: String
)
