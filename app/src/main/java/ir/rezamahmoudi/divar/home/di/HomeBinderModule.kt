package ir.rezamahmoudi.divar.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.rezamahmoudi.divar.home.data.repository.HomeRepositoryImpl
import ir.rezamahmoudi.divar.home.domain.repository.HomeRepository

@Module
@InstallIn(ViewModelComponent::class)
interface HomeBinderModule {

    @Binds
    fun bindHomeRepository(repo: HomeRepositoryImpl): HomeRepository
}
