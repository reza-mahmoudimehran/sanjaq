package ir.rezamahmoudi.divar.home.data.repository

import androidx.paging.PagingData
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_ENTITY_TEST_OBJECT_1
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_ENTITY_TEST_OBJECT_2
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_ENTITY_TEST_OBJECT_3
import ir.rezamahmoudi.divar.core.util.fakedata.WIDGET_ENTITY_TEST_OBJECT_4
import ir.rezamahmoudi.divar.home.data.entity.WidgetEntity
import ir.rezamahmoudi.divar.home.domain.repository.HomeRepository
import ir.rezamahmoudi.divar.home.domain.usecase.FetchPostsParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakeHomeRepository @Inject constructor() : HomeRepository {

    private val widgetEntities = listOf(WIDGET_ENTITY_TEST_OBJECT_1, WIDGET_ENTITY_TEST_OBJECT_2, WIDGET_ENTITY_TEST_OBJECT_3, WIDGET_ENTITY_TEST_OBJECT_4)
    override suspend fun fetchPosts(params: FetchPostsParams): Flow<PagingData<WidgetEntity>> =
        flowOf(PagingData.from(widgetEntities))
}
