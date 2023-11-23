package ir.rezamahmoudi.divar.home.data.datasource

import ir.rezamahmoudi.divar.home.data.model.FetchPostsBody
import ir.rezamahmoudi.divar.home.data.model.FetchPostsResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface HomeApi {
    @POST(value = "v1/post/list")
    suspend fun fetchPosts(
        @Query("city") selectedCityId: String,
        @Body body: FetchPostsBody
    ): FetchPostsResponse
}
