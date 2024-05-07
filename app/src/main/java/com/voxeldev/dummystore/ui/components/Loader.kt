package com.voxeldev.dummystore.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.voxeldev.dummystore.ui.base.BaseViewModel

/**
 * @author nvoxel
 */
@Composable
fun <T : BaseViewModel> Loader(
    modifier: Modifier = Modifier,
    viewModel: T,
) {
    val loading = viewModel.loading.observeAsState()
    if (loading.value == true) {
        Loader(modifier = modifier)
    }
}

@Composable
fun Loader(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator()
    }
}
