package com.voxeldev.dummystore.domain.repository

import com.voxeldev.dummystore.domain.model.response.Product
import com.voxeldev.dummystore.domain.model.response.ProductList

/**
 * @author nvoxel
 */
interface ProductRepository {

    fun getProduct(id: Int): Result<Product>

    fun getProducts(skip: Int, limit: Int, statement: String): Result<ProductList>

    fun getProductsByCategory(category: String): Result<ProductList>
}
