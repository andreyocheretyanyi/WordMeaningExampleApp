package com.aocheretyabyi.di

import com.aocheretyabyi.data.cache.SimpleLocalCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
    @Provides
    @Singleton
    fun provideCache(): SimpleLocalCache = SimpleLocalCache()
}