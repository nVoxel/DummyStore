package com.voxeldev.dummystore.domain.usecase

import com.voxeldev.dummystore.domain.model.response.CategoryList
import com.voxeldev.dummystore.domain.repository.CategoryRepository
import com.voxeldev.dummystore.domain.usecase.base.BaseUseCase
import javax.inject.Inject

/**
 * @author nvoxel
 */
class GetCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository,
) : BaseUseCase<BaseUseCase.NoParams, CategoryList>() {

    override fun run(params: NoParams): Result<CategoryList> =
        categoryRepository.getCategories()
}
