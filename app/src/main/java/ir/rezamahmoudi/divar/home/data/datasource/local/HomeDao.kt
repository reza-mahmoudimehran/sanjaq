package ir.rezamahmoudi.divar.home.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.rezamahmoudi.divar.core.util.constant.DatabaseConstants.WIDGETS_TABLE_NAME
import ir.rezamahmoudi.divar.home.data.entity.WidgetEntity

@Dao
interface HomeDao {
    @Insert
    suspend fun insertCityWidgets(widgets: List<WidgetEntity>)

    @Query("SELECT * FROM $WIDGETS_TABLE_NAME where city_id = :selectedCityId")
    fun getCityWidgets(selectedCityId: String): PagingSource<Int, WidgetEntity>

    @Query("DELETE FROM $WIDGETS_TABLE_NAME where city_id = :selectedCityId")
    suspend fun deleteCityWidgets(selectedCityId: String)
}
