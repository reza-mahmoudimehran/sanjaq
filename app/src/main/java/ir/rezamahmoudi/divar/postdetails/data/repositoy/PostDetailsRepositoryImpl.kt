package ir.rezamahmoudi.divar.postdetails.data.repositoy

import ir.rezamahmoudi.divar.postdetails.data.datasource.local.PostDetailsLocalDataSource
import ir.rezamahmoudi.divar.postdetails.data.datasource.remote.PostDetailsRemoteDataSource
import ir.rezamahmoudi.divar.postdetails.data.entity.PostDetailsEntity
import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import ir.rezamahmoudi.divar.postdetails.domain.repository.PostDetailsRepository
import ir.rezamahmoudi.divar.postdetails.domain.usecase.FetchPostDetailsParams
import javax.inject.Inject

class PostDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: PostDetailsRemoteDataSource,
    private val localDataSource: PostDetailsLocalDataSource
) : PostDetailsRepository {
    override suspend fun fetchPostDetails(params: FetchPostDetailsParams): Result<PostDetailsDto> =
        remoteDataSource.fetchPostDetails(params = params)

    override suspend fun insertPostDetails(postDetails: PostDetailsEntity) =
        localDataSource.insertPostDetails(postDetails = postDetails)

    override suspend fun getCachedPostDetails(postToken: String): Result<PostDetailsEntity> =
        localDataSource.getPostDetails(postToken = postToken)
}
