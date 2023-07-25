package com.satyajit.myshop.ui.base

sealed interface UiState<out T> {

    data class Success<T>(val data: T) : UiState<T>

    data class Error(val message: String) : UiState<Nothing>

    data class Loading(val isLoading: Boolean) : UiState<Nothing>


}