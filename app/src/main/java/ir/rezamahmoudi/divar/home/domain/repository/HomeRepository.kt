package ir.rezamahmoudi.divar.home.domain.repository

import androidx.paging.PagingData
import ir.rezamahmoudi.divar.home.data.entity.WidgetEntity
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsParams
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun fetchPosts(params: FetchPostsParams): Flow<PagingData<WidgetEntity>>
}
