package com.satyajit.myshop.ui.productdetailscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.satyajit.myshop.di.component.ApplicationComponent

@Composable
fun ProductDetailsRoute(productId: String,applicationComponent: ApplicationComponent,onClickOfBack:()->Unit) {

    val viewModel: ProductDetailsViewModel =
        viewModel(factory = applicationComponent.getProductDetailsViewModelFactory())

    viewModel.fethcProductByID(productById = productId.toInt())

    val uiStateProducts = viewModel.uiStateProducts.collectAsState().value

    ProductDetailsScreen(uiStateProducts, onClickOfBack =onClickOfBack )
}