package ir.rezamahmoudi.divar.postdetails.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.rezamahmoudi.divar.postdetails.data.datasource.local.PostDetailsLocalDataSource
import ir.rezamahmoudi.divar.postdetails.data.datasource.local.PostDetailsLocalDataSourceImpl
import ir.rezamahmoudi.divar.postdetails.data.datasource.remote.PostDetailsRemoteDataSource
import ir.rezamahmoudi.divar.postdetails.data.datasource.remote.PostDetailsRemoteDataSourceImpl
import ir.rezamahmoudi.divar.postdetails.data.repositoy.PostDetailsRepositoryImpl
import ir.rezamahmoudi.divar.postdetails.domain.repository.PostDetailsRepository

@Module
@InstallIn(ViewModelComponent::class)
interface PostDetailsBinderModule {

    @Binds
    fun bindPostDetailsRepository(repo: PostDetailsRepositoryImpl): PostDetailsRepository

    @Binds
    fun bindPostDetailsRemoteDataSource(ds: PostDetailsRemoteDataSourceImpl): PostDetailsRemoteDataSource

    @Binds
    fun bindPostDetailsLocalDataSource(ds: PostDetailsLocalDataSourceImpl): PostDetailsLocalDataSource
}
