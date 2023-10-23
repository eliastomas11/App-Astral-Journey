package com.example.astraljourney.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DispatcherIo
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DispatcherDefault

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DispatcherMain



