package com.satyajit.myshop.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.data.repository.HomeRepository
import com.satyajit.myshop.ui.base.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _uiStateProducts = MutableStateFlow<UiState<List<Product>>>(UiState.Loading(true))

    val uiStateProducts: StateFlow<UiState<List<Product>>> = _uiStateProducts.asStateFlow()

    init {
        fetchAllProducts()
    }

    fun fetchAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            homeRepository.getAllProducts()
                .catch { e ->
                    _uiStateProducts.value = UiState.Error(e.toString())
                }.collect {
                    _uiStateProducts.value = UiState.Success(it)
                }
        }
    }

}