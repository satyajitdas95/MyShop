package com.satyajit.myshop.ui.homescreen

import ShopDetails
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satyajit.myshop.R
import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.ui.base.UiState
import com.satyajit.myshop.ui.custom.showErrorMessageWithRetry
import com.satyajit.myshop.ui.custom.showLoading

@Composable
fun HomeScreen(
    uiStateProducts: UiState<List<Product>>,
    onRetryClicked: () -> Unit,
    onSearchClicked: () -> Unit,
    onClickOfProduct: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        HomeScreenTopHeader(onSearchClicked = onSearchClicked)

        ShopDetails()

        when (uiStateProducts) {

            is UiState.Loading -> {
                if(uiStateProducts.isLoading){
                    showLoading()
                }
            }

            is UiState.Error -> {
                showErrorMessageWithRetry(
                    stringResource(id = R.string.app_name),
                    onRetryClicked
                )
            }

            is UiState.Success -> {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = stringResource(id = R.string.label_all_products),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                LazyRow(
                    modifier = Modifier.heightIn(max = 480.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(uiStateProducts.data) { product ->
                        SingleProductItem(product = product, onClickOfProduct = onClickOfProduct)
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        HomeScreenBottomBar()

        Spacer(
            modifier = Modifier.height(30.dp)
        )

    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    Surface {
        val uilist = UiState.Success<List<Product>>(emptyList())
        HomeScreen(uilist, {}, {}, onClickOfProduct={})
    }
}