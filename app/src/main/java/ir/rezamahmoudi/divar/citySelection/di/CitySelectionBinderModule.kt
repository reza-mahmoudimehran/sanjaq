package ir.rezamahmoudi.divar.cityselection.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.rezamahmoudi.divar.cityselection.data.datasource.local.CitySelectionLocalDataSource
import ir.rezamahmoudi.divar.cityselection.data.datasource.local.CitySelectionLocalDataSourceImpl
import ir.rezamahmoudi.divar.cityselection.data.datasource.remote.CitySelectionRemoteDataSource
import ir.rezamahmoudi.divar.cityselection.data.datasource.remote.CitySelectionRemoteDataSourceImpl
import ir.rezamahmoudi.divar.cityselection.data.repository.CitySelectionRepositoryImpl
import ir.rezamahmoudi.divar.cityselection.domain.repository.CitySelectionRepository

@Module
@InstallIn(ViewModelComponent::class)
interface CitySelectionBinderModule {

    @Binds
    fun bindCitySelectionRepository(repo: CitySelectionRepositoryImpl): CitySelectionRepository

    @Binds
    fun bindCitySelectionRemoteDataSource(ds: CitySelectionRemoteDataSourceImpl): CitySelectionRemoteDataSource

    @Binds
    fun bindCitySelectionLocalDataSource(ds: CitySelectionLocalDataSourceImpl): CitySelectionLocalDataSource
}
