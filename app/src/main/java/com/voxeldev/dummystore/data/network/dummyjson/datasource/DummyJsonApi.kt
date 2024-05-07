package com.voxeldev.dummystore.data.network.dummyjson.datasource

import com.voxeldev.dummystore.data.network.dummyjson.datasource.response.CategoriesResponse
import com.voxeldev.dummystore.data.network.dummyjson.datasource.response.ProductResponse
import com.voxeldev.dummystore.data.network.dummyjson.datasource.response.ProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author nvoxel
 */
interface DummyJsonApi {

    @GET("products/{id}")
    fun getProduct(@Path("id") id: Int): Call<ProductResponse>

    @GET("products/search")
    fun getProducts(@Query("skip") skip: Int, @Query("limit") limit: Int, @Query("q") statement: String): Call<ProductsResponse>

    @GET("products/category/{category}")
    fun getProductsByCategory(@Path("category") category: String): Call<ProductsResponse>

    @GET("products/categories")
    fun getCategories(): Call<CategoriesResponse>
}
