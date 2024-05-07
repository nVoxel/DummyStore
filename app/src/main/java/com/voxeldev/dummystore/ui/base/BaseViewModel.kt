package com.voxeldev.dummystore.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.voxeldev.dummystore.utils.livedata.SingleLiveEvent

/**
 * @author nvoxel
 */
abstract class BaseViewModel : ViewModel() {

    protected val _exception: SingleLiveEvent<Throwable> = SingleLiveEvent()
    val exception: SingleLiveEvent<Throwable> = _exception

    protected val _loading: MutableLiveData<Boolean> = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    protected fun handleException(exception: Throwable) {
        _exception.postValue(exception)
        _loading.postValue(false)
    }
}
