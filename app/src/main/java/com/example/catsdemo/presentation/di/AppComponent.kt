package com.example.catsdemo.presentation.di

import com.example.catsdemo.data.mappers.CatsApiResponseMapper
import com.example.catsdemo.data.repositories.catsfragment.CatsRepositoryImpl
import com.example.catsdemo.data.service.NetworkModule
import com.example.catsdemo.data.utils.Service
import com.example.catsdemo.domain.usecases.GetCatsUseCase
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, CatsModule::class])
interface AppComponent {

    fun getCatsUseCase(): GetCatsUseCase

}

@Module
object AppModule {

    @Provides
    @Singleton
    fun provideNetworkModule(service: Service) = NetworkModule(service)

    @Provides
    @Singleton
    fun provideService() = Service()

}

@Module
object CatsModule {

    @Provides
    @Singleton
    fun provideGetCatsUseCase(catsRepositoryImpl: CatsRepositoryImpl) =
        GetCatsUseCase(catsRepositoryImpl)

    @Provides
    @Singleton
    fun provideCatRepository(
        networkModule: NetworkModule,
        catsApiResponseMapper: CatsApiResponseMapper
    ) = CatsRepositoryImpl(networkModule, catsApiResponseMapper)

    @Provides
    @Singleton
    fun provideCatsApiResponseMapper() = CatsApiResponseMapper()

}