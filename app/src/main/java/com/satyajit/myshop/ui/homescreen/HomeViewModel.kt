package com.satyajit.myshop.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satyajit.myshop.data.model.AllProductsResponse
import com.satyajit.myshop.data.repository.HomeRepository
import com.satyajit.myshop.ui.base.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository:  HomeRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<AllProductsResponse.Product>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<AllProductsResponse.Product>>> = _uiState.asStateFlow()

    init {
        fetchAllProducts()
    }
    fun fetchAllProducts() {
        viewModelScope.launch {
            homeRepository.getAllProducts()
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }.collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}