package com.voxeldev.dummystore.domain.model.response

/**
 * @author nvoxel
 */
data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val priceWithoutDiscount: Int,
    val discountPercentage: Int,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnailUrl: String,
    val imageUrls: List<String>,
)
