package com.voxeldev.dummystore.data.network.dummyjson

import com.voxeldev.dummystore.data.mapper.CategoriesMapper
import com.voxeldev.dummystore.data.network.base.BaseRepository
import com.voxeldev.dummystore.data.network.dummyjson.datasource.DummyJsonApi
import com.voxeldev.dummystore.domain.model.response.CategoryList
import com.voxeldev.dummystore.domain.repository.CategoryRepository
import com.voxeldev.dummystore.utils.platform.NetworkHandler
import javax.inject.Inject

/**
 * @author nvoxel
 */
class DefaultCategoryRepository @Inject constructor(
    networkHandler: NetworkHandler,
    private val dummyJsonApi: DummyJsonApi,
    private val categoriesMapper: CategoriesMapper,
) : BaseRepository(networkHandler = networkHandler), CategoryRepository {

    override fun getCategories(): Result<CategoryList> =
        request(
            call = dummyJsonApi.getCategories(),
            transform = { categoriesResponse -> categoriesMapper.toModel(categoriesResponse = categoriesResponse) },
        )
}
