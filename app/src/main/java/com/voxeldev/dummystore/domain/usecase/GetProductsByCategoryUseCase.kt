package com.voxeldev.dummystore.domain.usecase

import com.voxeldev.dummystore.domain.model.request.ProductsRequest
import com.voxeldev.dummystore.domain.model.response.ProductList
import com.voxeldev.dummystore.domain.repository.ProductRepository
import com.voxeldev.dummystore.domain.usecase.base.ProductListSource
import javax.inject.Inject

/**
 * @author nvoxel
 */
class GetProductsByCategorySyncUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) : ProductListSource {

    override fun invoke(params: ProductsRequest): Result<ProductList> =
        productRepository.getProductsByCategory(category = params.category ?: DEFAULT_CATEGORY)

    private companion object {
        const val DEFAULT_CATEGORY = ""
    }
}
