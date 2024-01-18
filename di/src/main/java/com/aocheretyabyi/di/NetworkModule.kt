package com.aocheretyabyi.di

import com.aocheretyabyi.data1.network.Api
import com.aocheretyabyi.data1.network.SimpleInterceptor
import com.aocheretyabyi.data.util.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideSimpleInterceptor(): SimpleInterceptor {
        return SimpleInterceptor()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideOkHttp(simpleInterceptor: SimpleInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(simpleInterceptor)
            .connectTimeout(Constants.READ_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constants.READ_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create((gson)))
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

}