package ir.rezamahmoudi.divar.postdetails.domain.usecase

import ir.rezamahmoudi.divar.postdetails.domain.repository.PostDetailsRepository
import ir.rezamahmoudi.divar.postdetails.presentation.model.PostDetailsUiModel
import javax.inject.Inject

class FetchPostDetailsUseCase @Inject constructor(
    private val repository: PostDetailsRepository
) {
    suspend operator fun invoke(postToken: String): Result<PostDetailsUiModel> =
        repository.fetchPostDetails(params = FetchPostDetailsParams(postToken = postToken))
            .map { it.asDomain() }
}

data class FetchPostDetailsParams(
    val postToken: String
)
