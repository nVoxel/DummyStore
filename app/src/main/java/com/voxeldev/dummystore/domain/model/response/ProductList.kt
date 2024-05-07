package com.voxeldev.dummystore.domain.model.response

/**
 * @author nvoxel
 */
data class ProductList(
    val products: List<Product>,
    val totalProducts: Int,
    val skip: Int,
    val limit: Int,
)
