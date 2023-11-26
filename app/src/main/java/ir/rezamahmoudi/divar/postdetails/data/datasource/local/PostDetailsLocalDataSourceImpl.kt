package ir.rezamahmoudi.divar.postdetails.data.datasource.local

import ir.rezamahmoudi.divar.postdetails.data.entity.PostDetailsEntity
import javax.inject.Inject

class PostDetailsLocalDataSourceImpl @Inject constructor(
    private val dao: PostDetailsDao
) : PostDetailsLocalDataSource {
    override suspend fun insertPostDetails(postDetails: PostDetailsEntity): Result<Unit> =
        runCatching { dao.insertPostDetails(postDetails = postDetails) }

    override suspend fun getPostDetails(postToken: String): Result<PostDetailsEntity> =
        runCatching { dao.getPostDetails(postToken = postToken) }
}
