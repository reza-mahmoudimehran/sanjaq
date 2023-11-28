package ir.rezamahmoudi.divar.postdetails.data.datasource.remote

import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import ir.rezamahmoudi.divar.postdetails.domain.usecase.FetchPostDetailsParams
import javax.inject.Inject

class PostDetailsRemoteDataSourceImpl @Inject constructor(
    private val api: PostDetailsApi
) : PostDetailsRemoteDataSource {
    override suspend fun fetchPostDetails(params: FetchPostDetailsParams): Result<PostDetailsDto> =
        runCatching { api.fetchPostDetails(postToken = params.postToken) }
}
