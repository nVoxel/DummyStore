package com.voxeldev.dummystore.data.mapper

import com.voxeldev.dummystore.data.network.dummyjson.datasource.response.ProductResponse
import com.voxeldev.dummystore.data.network.dummyjson.datasource.response.ProductsResponse
import com.voxeldev.dummystore.domain.model.response.Product
import com.voxeldev.dummystore.domain.model.response.ProductList
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.roundToInt

/**
 * @author nvoxel
 */
@Singleton
class ProductsMapper @Inject constructor() {

    fun toModel(productsResponse: ProductsResponse): ProductList =
        ProductList(
            products = productsResponse.products.map { toModel(productResponse = it) },
            totalProducts = productsResponse.total,
            skip = productsResponse.skip,
            limit = productsResponse.limit,
        )

    fun toModel(productResponse: ProductResponse): Product =
        Product(
            id = productResponse.id,
            title = productResponse.title,
            description = productResponse.description,
            price = productResponse.price,
            priceWithoutDiscount = (100 * productResponse.price / (100 - productResponse.discountPercentage)).roundToInt(),
            discountPercentage = productResponse.discountPercentage.roundToInt(),
            rating = productResponse.rating,
            stock = productResponse.stock,
            brand = productResponse.brand,
            category = productResponse.category,
            thumbnailUrl = productResponse.thumbnail,
            imageUrls = productResponse.images,
        )
}
