package com.voxeldev.dummystore.domain.model.response

/**
 * @author nvoxel
 */
data class CategoryList(
    val categories: List<String>,
    val formattedCategories: List<String>,
)
