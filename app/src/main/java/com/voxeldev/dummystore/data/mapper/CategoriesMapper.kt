package com.voxeldev.dummystore.data.mapper

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.voxeldev.dummystore.data.network.dummyjson.datasource.response.CategoriesResponse
import com.voxeldev.dummystore.domain.model.response.CategoryList
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author nvoxel
 */
@Singleton
class CategoriesMapper @Inject constructor() {

    fun toModel(categoriesResponse: CategoriesResponse, locale: Locale = Locale.current): CategoryList =
        CategoryList(
            categories = categoriesResponse,
            formattedCategories = categoriesResponse.map { it.capitalize(locale = locale) },
        )
}
