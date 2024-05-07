package com.voxeldev.dummystore.di.modules

import com.voxeldev.dummystore.BuildConfig
import com.voxeldev.dummystore.data.network.dummyjson.datasource.DummyJsonApi
import com.voxeldev.dummystore.utils.providers.StringResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author nvoxel
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG && BuildConfig.BUILD_TYPE.contains(DEBUG_MARKER)) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    fun provideCameraApiHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideDummyJsonApi(
        stringResourceProvider: StringResourceProvider,
        cameraApiHttpClient: OkHttpClient,
    ): DummyJsonApi =
        Retrofit.Builder()
            .baseUrl(stringResourceProvider.getDummyJsonApiBaseUrl())
            .client(cameraApiHttpClient)
            .addConverterFactory(
                Json.asConverterFactory(
                    contentType = "application/json; charset=UTF8".toMediaType()
                )
            )
            .build()
            .create(DummyJsonApi::class.java)

    private companion object {
        const val DEBUG_MARKER = "debug"
        const val CONNECTION_TIMEOUT = 10L
    }
}
