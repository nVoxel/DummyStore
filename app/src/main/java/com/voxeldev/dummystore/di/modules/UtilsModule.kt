package com.voxeldev.dummystore.di.modules

import android.content.Context
import com.voxeldev.dummystore.utils.providers.StringResourceProvider
import com.voxeldev.dummystore.utils.providers.StringResourceProviderContextImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author nvoxel
 */
@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    @Singleton
    fun provideStringResourceProvider(
        @ApplicationContext context: Context,
    ): StringResourceProvider = StringResourceProviderContextImpl(context = context)
}
