package ir.rezamahmoudi.divar.core.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetPostRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetSubTitleRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetTitleRowDto
import ir.rezamahmoudi.divar.core.data.model.widget.WidgetType

@Module
@InstallIn(SingletonComponent::class)
object MoshiModule {

    @Provides
    fun provideMoshi(): Moshi = Moshi
        .Builder()
        .add(
            PolymorphicJsonAdapterFactory
                .of(WidgetDto::class.java, "widget_type")
                .withSubtype(WidgetTitleRowDto::class.java, WidgetType.TITLE_ROW.name)
                .withSubtype(WidgetSubTitleRowDto::class.java, WidgetType.SUBTITLE_ROW.name)
                .withSubtype(WidgetPostRowDto::class.java, WidgetType.POST_ROW.name)
        )
        .add(KotlinJsonAdapterFactory())
        .build()
}
