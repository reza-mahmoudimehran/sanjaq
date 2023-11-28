package ir.rezamahmoudi.divar.core.data.typeconverter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import javax.inject.Inject

@ProvidedTypeConverter
class WidgetTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun widgetFromJson(json: String): WidgetDto? {
        return moshi.adapter(WidgetDto::class.java).fromJson(json)
    }

    @TypeConverter
    fun widgetToJson(entity: WidgetDto): String {
        return moshi.adapter(WidgetDto::class.java).toJson(entity)
    }

    @TypeConverter
    fun widgetListFromJson(json: String): List<WidgetDto> {
        return moshi.adapter<List<WidgetDto>>(
            Types.newParameterizedType(
                List::class.java,
                WidgetDto::class.java
            )
        ).fromJson(json).orEmpty()
    }

    @TypeConverter
    fun widgetListToJson(entity: List<WidgetDto>): String {
        return moshi.adapter<List<WidgetDto>>(
            Types.newParameterizedType(
                List::class.java,
                WidgetDto::class.java
            )
        ).toJson(entity)
    }
}
