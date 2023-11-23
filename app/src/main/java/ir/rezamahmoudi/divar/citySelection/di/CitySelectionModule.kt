package ir.rezamahmoudi.divar.citySelection.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.rezamahmoudi.divar.citySelection.data.datasource.CitySelectionApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class CitySelectionModule {

    @Provides
    fun provideCitySelectionApi(retrofit: Retrofit): CitySelectionApi {
        return retrofit.create(CitySelectionApi::class.java)
    }
}
