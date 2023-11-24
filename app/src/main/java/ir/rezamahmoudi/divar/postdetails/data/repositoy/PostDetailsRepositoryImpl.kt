package ir.rezamahmoudi.divar.postdetails.data.repositoy

import ir.rezamahmoudi.divar.core.util.log.showErrorLog
import ir.rezamahmoudi.divar.postdetails.data.datasource.PostDetailsRemoteDataSource
import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import ir.rezamahmoudi.divar.postdetails.domain.repository.PostDetailsRepository
import ir.rezamahmoudi.divar.postdetails.domain.usecase.FetchPostDetailsParams
import javax.inject.Inject

class PostDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: PostDetailsRemoteDataSource
) : PostDetailsRepository {
    override suspend fun fetchPostDetails(params: FetchPostDetailsParams): Result<PostDetailsDto> =
        remoteDataSource.fetchPostDetails(params = params).apply {
            onSuccess {
                showErrorLog("onSuccess $it")
            }
            onFailure {
                showErrorLog("onFailure $it")
            }
        }
}
