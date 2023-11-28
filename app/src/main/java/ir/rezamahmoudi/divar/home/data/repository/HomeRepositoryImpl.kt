package ir.rezamahmoudi.divar.home.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.rezamahmoudi.divar.app.data.local.DivarDatabase
import ir.rezamahmoudi.divar.home.data.datasource.remote.FetchPostsRemoteMediator
import ir.rezamahmoudi.divar.home.data.datasource.remote.HomeApi
import ir.rezamahmoudi.divar.home.data.entity.WidgetEntity
import ir.rezamahmoudi.divar.home.domain.repository.HomeRepository
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsParams
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: HomeApi,
    private val divarDb: DivarDatabase
) : HomeRepository {

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun fetchPosts(params: FetchPostsParams): Flow<PagingData<WidgetEntity>> = Pager(
        config = PagingConfig(pageSize = PAGE_SIZE),
        remoteMediator = FetchPostsRemoteMediator(
            api = api,
            divarDb = divarDb,
            fetchPostsParams = params
        ),
        pagingSourceFactory = {
            divarDb.getHomeDao().getCityWidgets(params.selectedCityId)
        }
    ).flow

    companion object {
        const val PAGE_SIZE = 20
    }
}
