package com.voxeldev.dummystore.ui.navigation

/**
 * @author nvoxel
 */
sealed class NavigationScreen(
    val route: String? = null,
    val routeWithArguments: String,
) {

    data object Catalog : NavigationScreen(
        routeWithArguments = "catalog",
    )

    data object Details : NavigationScreen(
        route = "details",
        routeWithArguments = "details/{productId}",
    )
}
