package ir.rezamahmoudi.divar.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.rezamahmoudi.divar.app.data.local.DivarDatabase
import ir.rezamahmoudi.divar.core.data.typeconverter.WidgetTypeConverter

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context, widgetTypeConverter: WidgetTypeConverter) =
        DivarDatabase.getDatabase(context = context, widgetTypeConverter = widgetTypeConverter)

    @Provides
    fun providePostDetailsDao(database: DivarDatabase) = database.getPostDetailsDao()
}
