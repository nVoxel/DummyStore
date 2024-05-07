package com.voxeldev.dummystore.domain.usecase

import com.voxeldev.dummystore.domain.model.response.Product
import com.voxeldev.dummystore.domain.repository.ProductRepository
import com.voxeldev.dummystore.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * @author nvoxel
 */
class GetProductUseCase @Inject constructor(
    private val productRepository: ProductRepository,
) : BaseUseCase<Int, Product>() {

    override fun run(params: Int): Result<Product> =
        productRepository.getProduct(id = params)
}
