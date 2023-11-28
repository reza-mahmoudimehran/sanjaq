package ir.rezamahmoudi.divar.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.rezamahmoudi.divar.core.data.datastore.DataStoreRepositoryImpl
import ir.rezamahmoudi.divar.core.domain.datastore.DataStoreRepository
import ir.rezamahmoudi.divar.core.util.network.connection.NetworkConnection
import ir.rezamahmoudi.divar.core.util.network.connection.NetworkConnectionImpl

@Module
@InstallIn(SingletonComponent::class)
interface CoreBinderModule {

    @Binds
    fun provideDataStoreRepository(dataStoreRepositoryImpl: DataStoreRepositoryImpl): DataStoreRepository

    @Binds
    fun bindsNetworkConnection(networkConnectionImpl: NetworkConnectionImpl): NetworkConnection
}
