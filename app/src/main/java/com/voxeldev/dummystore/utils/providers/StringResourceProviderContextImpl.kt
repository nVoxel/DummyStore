package com.voxeldev.dummystore.utils.providers

import android.content.Context
import com.voxeldev.dummystore.R

/**
 * @author nvoxel
 */
class StringResourceProviderContextImpl(context: Context) : StringResourceProvider {

    private val resources = context.resources

    override fun getDummyJsonApiBaseUrl(): String = resources.getString(R.string.dummyjson_api_base_url)
}
