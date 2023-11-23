package ir.rezamahmoudi.divar.home.domain.repository

import androidx.paging.PagingData
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsParams
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun fetchPosts(params: FetchPostsParams): Flow<PagingData<WidgetDto>>
}
