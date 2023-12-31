package ir.rezamahmoudi.divar.cityselection.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.rezamahmoudi.divar.cityselection.data.datasource.CitySelectionRemoteDataSource
import ir.rezamahmoudi.divar.cityselection.data.datasource.CitySelectionRemoteDataSourceImpl
import ir.rezamahmoudi.divar.cityselection.data.repository.CitySelectionRepositoryImpl
import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository

@Module
@InstallIn(ViewModelComponent::class)
interface CitySelectionBinderModule {

    @Binds
    fun bindCitySelectionRepository(repo: CitySelectionRepositoryImpl): CitySelectionRepository

    @Binds
    fun bindCitySelectionRemoteDataSource(ds: CitySelectionRemoteDataSourceImpl): CitySelectionRemoteDataSource
}
