package ir.rezamahmoudi.divar.app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.rezamahmoudi.divar.core.data.typeconverter.WidgetTypeConverter
import ir.rezamahmoudi.divar.core.util.constant.CoreConstants.DATABASE_NAME
import ir.rezamahmoudi.divar.postdetails.data.datasource.local.PostDetailsDao
import ir.rezamahmoudi.divar.postdetails.data.entity.PostDetailsEntity

@Database(
    entities = [
        PostDetailsEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(WidgetTypeConverter::class)
abstract class DivarDatabase : RoomDatabase() {

    abstract fun getPostDetailsDao(): PostDetailsDao

    companion object {
        // Volatile annotation means any change to this field
        // are immediately visible to other threads.
        @Volatile
        private var INSTANCE: DivarDatabase? = null

        fun getDatabase(context: Context, widgetTypeConverter: WidgetTypeConverter): DivarDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            // here synchronised used for blocking the other thread
            // from accessing another while in a specific code execution.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DivarDatabase::class.java,
                    DATABASE_NAME
                ).addTypeConverter(widgetTypeConverter).build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
