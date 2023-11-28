package ir.rezamahmoudi.divar.home.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.core.util.constant.DatabaseConstants.WIDGETS_TABLE_NAME

@Entity(
    tableName = WIDGETS_TABLE_NAME
)
data class WidgetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val widgetDto: WidgetDto,
    @ColumnInfo(name = "city_Id") val cityId: Int
)
