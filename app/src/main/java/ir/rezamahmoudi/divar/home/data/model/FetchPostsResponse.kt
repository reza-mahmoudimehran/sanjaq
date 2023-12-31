package ir.rezamahmoudi.divar.home.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto

@JsonClass(generateAdapter = true)
data class FetchPostsResponse(
    @Json(name = "widget_list") val widgetsList: List<WidgetDto>,
    @Json(name = "last_post_date") val lastPostDate: Long
)
