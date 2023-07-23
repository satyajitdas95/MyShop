package com.satyajit.myshop.ui.homescreen

import ShopDetails
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(onSearchClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        HomeScreenTopHeader(onSearchClicked = onSearchClicked)

        ShopDetails()
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    Surface {
        HomeScreen({})
    }
}