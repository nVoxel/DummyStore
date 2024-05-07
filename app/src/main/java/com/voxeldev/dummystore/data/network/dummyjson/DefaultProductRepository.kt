package com.voxeldev.dummystore.data.network.dummyjson

import com.voxeldev.dummystore.data.mapper.ProductsMapper
import com.voxeldev.dummystore.data.network.base.BaseRepository
import com.voxeldev.dummystore.data.network.dummyjson.datasource.DummyJsonApi
import com.voxeldev.dummystore.domain.model.response.Product
import com.voxeldev.dummystore.domain.model.response.ProductList
import com.voxeldev.dummystore.domain.repository.ProductRepository
import com.voxeldev.dummystore.utils.platform.NetworkHandler
import javax.inject.Inject

/**
 * @author nvoxel
 */
class DefaultProductRepository @Inject constructor(
    networkHandler: NetworkHandler,
    private val dummyJsonApi: DummyJsonApi,
    private val productsMapper: ProductsMapper,
) : BaseRepository(networkHandler = networkHandler), ProductRepository {

    override fun getProduct(id: Int): Result<Product> =
        request(
            call = dummyJsonApi.getProduct(id = id),
            transform = { productResponse -> productsMapper.toModel(productResponse = productResponse) },
        )

    override fun getProducts(skip: Int, limit: Int, statement: String): Result<ProductList> =
        request(
            call = dummyJsonApi.getProducts(skip = skip, limit = limit, statement = statement),
            transform = { productsResponse -> productsMapper.toModel(productsResponse = productsResponse) },
        )

    override fun getProductsByCategory(category: String): Result<ProductList> =
        request(
            call = dummyJsonApi.getProductsByCategory(category = category),
            transform = { productsResponse -> productsMapper.toModel(productsResponse = productsResponse) },
        )
}
