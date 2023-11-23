package ir.rezamahmoudi.divar.home.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.home.data.model.FetchPostsBody
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsParams

class FetchPostsPagingDataSource(
    private val api: HomeApi,
    private val fetchPostsParams: FetchPostsParams
) : PagingSource<Int, WidgetDto>() {

    override fun getRefreshKey(state: PagingState<Int, WidgetDto>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1) ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, WidgetDto> {
        val page = params.key ?: STARTING_PAGE_INDEX

        return try {
            val response = api.fetchPosts(
                selectedCityId = fetchPostsParams.selectedCityId,
                body = FetchPostsBody(page = page)
            )
            LoadResult.Page(
                data = response.posts,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.posts.isEmpty() || response.lastPostDate < 0) null else page.plus(1)
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}
