package com.voxeldev.dummystore.domain.usecase.base

import com.voxeldev.dummystore.domain.model.request.ProductsRequest
import com.voxeldev.dummystore.domain.model.response.ProductList

/**
 * @author nvoxel
 */
interface ProductListSource {

    operator fun invoke(params: ProductsRequest): Result<ProductList>
}
