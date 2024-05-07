package com.voxeldev.dummystore.di.modules

import com.voxeldev.dummystore.data.network.dummyjson.DefaultCategoryRepository
import com.voxeldev.dummystore.data.network.dummyjson.DefaultProductRepository
import com.voxeldev.dummystore.domain.repository.CategoryRepository
import com.voxeldev.dummystore.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author nvoxel
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCategoryRepository(
        categoryRepository: DefaultCategoryRepository,
    ): CategoryRepository

    @Binds
    abstract fun bindProductRepository(
        productRepository: DefaultProductRepository,
    ): ProductRepository
}
