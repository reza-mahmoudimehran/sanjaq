package ir.rezamahmoudi.divar.home.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FetchPostsBody(
    val page: Int,
    @Json(name = "last_post_date") val lastPostDate: Long = 0
)
