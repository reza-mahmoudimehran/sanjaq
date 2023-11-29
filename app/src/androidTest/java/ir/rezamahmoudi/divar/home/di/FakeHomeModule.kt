package ir.rezamahmoudi.divar.home.di

import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import ir.rezamahmoudi.divar.home.data.repository.FakeHomeRepository
import ir.rezamahmoudi.divar.home.domain.repository.HomeRepository
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [HomeBinderModule::class]
)
@Module
interface FakeHomeModule {

    @Singleton
    @Binds
    fun bindsHomeRepository(rp: FakeHomeRepository): HomeRepository
}
