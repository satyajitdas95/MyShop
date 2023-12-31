package com.satyajit.myshop.ui.searchscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.data.repository.SearchRepository
import com.satyajit.myshop.ui.base.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<List<Product>>>(UiState.Loading(false))

    val uiState: StateFlow<UiState<List<Product>>> = _uiState.asStateFlow()

    fun search(query: StateFlow<String>) {
        viewModelScope.launch {
            query.debounce(300)
                .filter { query ->
                    return@filter query.isNotEmpty()
                }
                .flowOn(Dispatchers.Default)
                .distinctUntilChanged()
                .flatMapLatest { query ->
                    _uiState.value = UiState.Loading(true)
                    searchRepository.getAllProducts(query)
                        .catch { e ->
                            emitAll(flowOf(emptyList()))
                        }
                }
                .flowOn(Dispatchers.IO)
                .collect { result ->
                    _uiState.value = UiState.Success(result)
                }
        }
    }

    fun updateText(text: String) {
        _uiState.value = UiState.Loading(false)
    }


}