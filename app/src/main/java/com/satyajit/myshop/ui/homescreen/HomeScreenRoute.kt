package com.satyajit.myshop.ui.homescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.satyajit.myshop.di.component.ApplicationComponent

@Composable
fun HomeScreenRoute(onSearchClicked: () -> Unit, applicationComponent: ApplicationComponent) {

    val viewModel: HomeViewModel =
        viewModel(factory = applicationComponent.getHomeViewModelFactory())

    val uiState = viewModel.uiState.collectAsState().value

    val onRetryClicked = { viewModel.fetchAllProducts() }

    HomeScreen(uiState, onRetryClicked = onRetryClicked, onSearchClicked = onSearchClicked)
}