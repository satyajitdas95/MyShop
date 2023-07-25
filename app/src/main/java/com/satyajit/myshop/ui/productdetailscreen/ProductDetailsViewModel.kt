package com.satyajit.myshop.ui.productdetailscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.data.repository.ProductDetailsRepository
import com.satyajit.myshop.ui.base.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProductDetailsViewModel (private val productDetailsRepository: ProductDetailsRepository): ViewModel() {

    private val _uiStateProducts = MutableStateFlow<UiState<Product>>(UiState.Loading(true))

    val uiStateProducts: StateFlow<UiState<Product>> = _uiStateProducts.asStateFlow()

    fun fethcProductByID(productById:Int) {
        viewModelScope.launch(Dispatchers.IO) {
            productDetailsRepository.getProductByID(productById)
                .catch { e ->
                    _uiStateProducts.value = UiState.Error(e.toString())
                }.collect {
                    _uiStateProducts.value = UiState.Success(it)
                }
        }
    }
}