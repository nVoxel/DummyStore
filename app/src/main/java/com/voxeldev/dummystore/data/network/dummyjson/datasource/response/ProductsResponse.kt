package com.voxeldev.dummystore.data.network.dummyjson.datasource.response

import kotlinx.serialization.Serializable

/**
 * @author nvoxel
 */
@Serializable
data class ProductsResponse(
    val products: List<ProductResponse>,
    val total: Int,
    val skip: Int,
    val limit: Int,
)

@Serializable
data class ProductResponse(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>,
)
