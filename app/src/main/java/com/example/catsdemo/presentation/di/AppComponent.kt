package com.example.catsdemo.presentation.di

import com.example.catsdemo.data.service.NetworkModule
import com.example.catsdemo.data.utils.Service
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {



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