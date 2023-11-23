package ir.rezamahmoudi.divar.postdetails.domain.usecase

import ir.rezamahmoudi.divar.postdetails.data.datasource.PostDetailsRemoteDataSource
import ir.rezamahmoudi.divar.postdetails.presentation.model.PostDetailsUiModel
import javax.inject.Inject

class FetchPostDetailsUseCase @Inject constructor(
    private val repository: PostDetailsRemoteDataSource
) {
    suspend operator fun invoke(postToken: String): Result<PostDetailsUiModel> =
        repository.fetchPostDetails(params = FetchPostDetailsParams(postToken = postToken))
            .map { it.asDomain() }
}

data class FetchPostDetailsParams(
    val postToken: String
)
