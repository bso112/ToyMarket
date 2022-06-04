package com.manta.topmarket.ui.main

import androidx.lifecycle.ViewModel
import com.manta.topmarket.model.Product
import com.manta.topmarket.repository.MainRepository
import com.manta.topmarket.ui.UiState
import com.manta.topmarket.util.updateUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _productList = MutableStateFlow<UiState<List<Product>>>(UiState())
    val productList = _productList.asStateFlow()

    init {
        updateUiState(_productList) {
            mainRepository.fetchProductList()
        }
    }



}