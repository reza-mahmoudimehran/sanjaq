package ir.rezamahmoudi.divar.postdetails.domain.repository

import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import ir.rezamahmoudi.divar.postdetails.domain.usecase.FetchPostDetailsParams

interface PostDetailsRepository {

    suspend fun fetchPostDetails(params: FetchPostDetailsParams): Result<PostDetailsDto>
}
