package ir.rezamahmoudi.divar.postdetails.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ir.rezamahmoudi.divar.postdetails.data.datasource.remote.PostDetailsApi
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class PostDetailsModule {

    @Provides
    fun providePostDetailsApi(retrofit: Retrofit): PostDetailsApi {
        return retrofit.create(PostDetailsApi::class.java)
    }
}
