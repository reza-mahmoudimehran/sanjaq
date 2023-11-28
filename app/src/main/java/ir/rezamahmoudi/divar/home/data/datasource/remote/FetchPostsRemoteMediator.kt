package ir.rezamahmoudi.divar.home.data.datasource.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import ir.rezamahmoudi.divar.app.data.local.DivarDatabase
import ir.rezamahmoudi.divar.home.data.entity.WidgetEntity
import ir.rezamahmoudi.divar.home.data.mappers.mapToEntity
import ir.rezamahmoudi.divar.home.data.model.FetchPostsBody
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsParams
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class FetchPostsRemoteMediator(
    private val divarDb: DivarDatabase,
    private val api: HomeApi,
    private val fetchPostsParams: FetchPostsParams
) : RemoteMediator<Int, WidgetEntity>() {

    @Volatile
    private var page = 0

    @Volatile
    private var lastPostDate = 0L

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, WidgetEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        page
                    } else {
                        page + 1
                    }
                }
            }

            val response = api.fetchPosts(
                selectedCityId = fetchPostsParams.selectedCityId,
                body = FetchPostsBody(page = loadKey, lastPostDate = lastPostDate)
            )
            if (loadType == LoadType.REFRESH) {
                lastPostDate = 0
                page = 0
            } else {
                lastPostDate = response.lastPostDate
                page++
            }

            divarDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    divarDb.getHomeDao().deleteCityWidgets(fetchPostsParams.selectedCityId)
                }
                val widgetEntities = response.widgetsList.mapToEntity(fetchPostsParams.selectedCityId.toInt())
                divarDb.getHomeDao().insertCityWidgets(widgetEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = response.widgetsList.isEmpty() || response.lastPostDate < 0
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}
