package com.voxeldev.dummystore.domain.repository

import com.voxeldev.dummystore.domain.model.response.CategoryList

/**
 * @author nvoxel
 */
interface CategoryRepository {

    fun getCategories(): Result<CategoryList>
}
