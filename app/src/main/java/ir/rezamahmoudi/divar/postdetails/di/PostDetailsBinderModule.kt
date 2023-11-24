package ir.rezamahmoudi.divar.postdetails.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.rezamahmoudi.divar.postdetails.data.datasource.PostDetailsRemoteDataSource
import ir.rezamahmoudi.divar.postdetails.data.datasource.PostDetailsRemoteDataSourceImpl
import ir.rezamahmoudi.divar.postdetails.data.repositoy.PostDetailsRepositoryImpl
import ir.rezamahmoudi.divar.postdetails.domain.repository.PostDetailsRepository

@Module
@InstallIn(ViewModelComponent::class)
interface PostDetailsBinderModule {

    @Binds
    fun bindPostDetailsRepository(repo: PostDetailsRepositoryImpl): PostDetailsRepository

    @Binds
    fun bindPostDetailsRemoteDataSource(ds: PostDetailsRemoteDataSourceImpl): PostDetailsRemoteDataSource
}
