package com.example.astraljourney.di

import com.example.astraljourney.domain.HoroscopeRepository
import com.example.astraljourney.domain.usecases.HoroscopeUseCases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideGetZodiacInfoUseCase(horoscopeRepository: HoroscopeRepository): GetZodiacSignInfo {
        return GetZodiacSignInfo(horoscopeRepository::getZodiacSign)
    }

    @Singleton
    @Provides
    fun provideGetZodiacList(horoscopeRepository: HoroscopeRepository): GetZodiacList{
        return GetZodiacList(horoscopeRepository::getZodiacList)
    }


}