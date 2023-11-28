package ir.rezamahmoudi.divar.postdetails.data.datasource.remote

import ir.rezamahmoudi.divar.postdetails.data.model.PostDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PostDetailsApi {

    @GET(value = "v1/post/view/{postToken}")
    suspend fun fetchPostDetails(
        @Path("postToken") postToken: String
    ): PostDetailsDto
}
