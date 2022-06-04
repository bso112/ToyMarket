package com.manta.topmarket.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manta.topmarket.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _toastMsg = MutableSharedFlow<String>()
    val toastMsg = _toastMsg.asSharedFlow()

    val productList = mainRepository.fetchProductList {
        _toastMsg.emit(it.message ?: "")
    }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

}