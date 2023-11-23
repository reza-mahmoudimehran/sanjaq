package ir.rezamahmoudi.divar.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.home.data.datasource.FetchPostsPagingDataSource
import ir.rezamahmoudi.divar.home.data.datasource.HomeApi
import ir.rezamahmoudi.divar.home.domain.repository.HomeRepository
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: HomeApi
) : HomeRepository {
    override suspend fun fetchPosts(params: FetchPostsParams): Flow<PagingData<WidgetDto>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        pagingSourceFactory = {
            FetchPostsPagingDataSource(
                api = api,
                fetchPostsParams = params
            )
        }
    ).flow

    companion object {
        const val PAGE_SIZE = 24
    }
}
