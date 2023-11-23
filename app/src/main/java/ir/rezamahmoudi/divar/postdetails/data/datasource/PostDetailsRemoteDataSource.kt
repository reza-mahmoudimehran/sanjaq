package ir.rezamahmoudi.divar.postdetails.data.datasource

import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import ir.rezamahmoudi.divar.postdetails.domain.usecase.FetchPostDetailsParams

interface PostDetailsRemoteDataSource {

    suspend fun fetchPostDetails(params: FetchPostDetailsParams): Result<PostDetailsDto>
}
