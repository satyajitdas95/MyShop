package com.satyajit.myshop.ui.searchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satyajit.myshop.R
import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.ui.base.UiState
import com.satyajit.myshop.ui.custom.showErrorMessageForNoData
import com.satyajit.myshop.ui.custom.showLoading
import com.satyajit.myshop.ui.homescreen.SingleProductItem

@Composable
fun SearchScreen(
    uiStateProducts: UiState<List<Product>>,
    placeholderText: String,
    onSearchTextChanged: (String) -> Unit,
    onClickOfProduct: (String) -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            SearchBar(
                modifier = Modifier
                    .padding(all = 12.dp)
                    .fillMaxWidth(),
                placeholderText = placeholderText,
                onSearchTextChanged = onSearchTextChanged
            )
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        when (uiStateProducts) {
            is UiState.Loading -> {
                if(uiStateProducts.isLoading){
                    showLoading()
                }
            }

            is UiState.Error -> {
                showErrorMessageForNoData(R.raw.error, stringResource(id = R.string.error_no_result_found))
            }

            is UiState.Success -> {
                if(uiStateProducts.data.isNotEmpty()){
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(3),
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)

                    ) {
                        items(uiStateProducts.data) { product ->
                            SingleProductItem(product = product,onClickOfProduct)
                        }
                    }
                }else{
                    showErrorMessageForNoData(R.raw.error, stringResource(id = R.string.error_no_result_found))
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

    }
}

@Preview
@Composable
fun SearchPreview() {
    val product = Product(
        1, "Mobile", "New Mobile phone", 100, 0.4, 5.5, 3, "", "", ""
    )
    val uiStateProducts: UiState<List<Product>> = UiState.Success(listOf(product))
    SearchScreen(
        uiStateProducts = uiStateProducts,
        stringResource(id = R.string.label_search_placeholder),{},{})
}
