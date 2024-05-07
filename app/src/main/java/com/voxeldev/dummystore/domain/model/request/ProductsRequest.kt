package com.voxeldev.dummystore.domain.model.request

/**
 * @author nvoxel
 */
data class ProductsRequest(
    val skip: Int,
    val limit: Int,
    val statement: String,
    val category: String? = null,
)
