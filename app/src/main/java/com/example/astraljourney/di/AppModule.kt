package com.example.astraljourney.di

import com.example.astraljourney.data.local.HoroscopeLocal
import com.example.astraljourney.data.local.HoroscopeLocalDataSource
import com.example.astraljourney.data.remote.HoroscopeApiService
import com.example.astraljourney.data.remote.HoroscopeRemote
import com.example.astraljourney.data.remote.HoroscopeRemoteDataSource
import com.example.astraljourney.data.repositories.HoroscopeRepositoryImpl
import com.example.astraljourney.domain.HoroscopeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHoroscopeRemote(horoscopeApiService: HoroscopeApiService): HoroscopeRemote {
        return HoroscopeRemoteDataSource(horoscopeApiService)
    }
    @Provides
    @Singleton
    fun provideHoroscopeLocal(): HoroscopeLocal {
        return HoroscopeLocalDataSource()
    }
    @Provides
    @Singleton
    fun provideHoroscopeRepository(@DispatcherIo dispatcher: CoroutineDispatcher, horoscopeRemote: HoroscopeRemote, horoscopeLocal: HoroscopeLocal): HoroscopeRepository {
        return HoroscopeRepositoryImpl(dispatcher, horoscopeRemote, horoscopeLocal)
    }
}