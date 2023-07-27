package com.cobacoba.ramalancuaca.di

import com.cobacoba.ramalancuaca.network.WeatherAPI
import com.cobacoba.ramalancuaca.utils.ConstValue
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@dagger.Module
class Module {

    @Provides
    @Singleton
    fun providesClient():OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addNetworkInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):WeatherAPI =
        Retrofit.Builder()
            .baseUrl(ConstValue.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(WeatherAPI::class.java)


}