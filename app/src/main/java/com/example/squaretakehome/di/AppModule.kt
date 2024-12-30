package com.example.squaretakehome.di

import com.example.squaretakehome.data.EmployeeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEmployeeApi() : EmployeeApi {

        val httpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(
                HttpLoggingInterceptor()
                .apply { level =
                    if(true)
                        HttpLoggingInterceptor.Level.BODY
                    else
                        HttpLoggingInterceptor.Level.BASIC
                })

        return Retrofit.Builder()
            .baseUrl(EmployeeApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(EmployeeApi::class.java)
    }
}