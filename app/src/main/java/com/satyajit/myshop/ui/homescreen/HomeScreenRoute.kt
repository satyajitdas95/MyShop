package com.satyajit.myshop.ui.homescreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.satyajit.myshop.di.component.ApplicationComponent

@Composable
fun HomeScreenRoute(
    onSearchClicked: () -> Unit,
    applicationComponent: ApplicationComponent,
    onClickOfProduct: (String) -> Unit
) {

    val viewModel: HomeViewModel =
        viewModel(factory = applicationComponent.getHomeViewModelFactory())

    val uiStateProducts = viewModel.uiStateProducts.collectAsState().value

    val onRetryClicked = { viewModel.fetchAllProducts() }

    HomeScreen(uiStateProducts = uiStateProducts, onRetryClicked = onRetryClicked, onSearchClicked = onSearchClicked, onClickOfProduct = onClickOfProduct)
}