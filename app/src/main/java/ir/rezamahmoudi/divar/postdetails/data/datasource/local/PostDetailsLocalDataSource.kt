package ir.rezamahmoudi.divar.postdetails.data.datasource.local

import ir.rezamahmoudi.divar.postdetails.data.entity.PostDetailsEntity

interface PostDetailsLocalDataSource {
    suspend fun insertPostDetails(postDetails: PostDetailsEntity)
    suspend fun getPostDetails(postToken: String): Result<PostDetailsEntity>
}
