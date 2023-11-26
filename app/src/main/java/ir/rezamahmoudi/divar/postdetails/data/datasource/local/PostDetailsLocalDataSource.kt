package ir.rezamahmoudi.divar.postdetails.data.datasource.local

import ir.rezamahmoudi.divar.postdetails.data.entity.PostDetailsEntity

interface PostDetailsLocalDataSource {
    suspend fun insertPostDetails(postDetails: PostDetailsEntity): Result<Unit>
    suspend fun getPostDetails(postToken: String): Result<PostDetailsEntity>
}
