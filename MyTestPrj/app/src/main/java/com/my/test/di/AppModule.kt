package com.my.test.di

import com.my.test.BuildConfig
import com.my.test.common.Constants
import com.my.test.data.remote.FindProvidersApi
import com.my.test.data.repository.FindProviderRepositoryImpl
import com.my.test.domain.repository.FindProviderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    private const val ACCEPT_LANGUAGE = "Accept-Language"

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        )

        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        return builder
            .addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header(ACCEPT_LANGUAGE, Locale.getDefault().language)
                    return@Interceptor chain.proceed(builder.build())
                }
            )
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun findProvidersApi(): FindProvidersApi {
        return Retrofit.Builder()
            .client(provideOkHttpClient())
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FindProvidersApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFindProviderRepository(api: FindProvidersApi): FindProviderRepository {
        return FindProviderRepositoryImpl(api)
    }
}