package com.satyajit.myshop.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satyajit.myshop.ui.searchscreen.SearchAppBar

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.primary)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Image(
                    imageVector = Icons.Default.Home,
                    contentDescription = "HomeScreen",
                    colorFilter = ColorFilter.tint(
                        Color.White
                    ), modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                )

                Image(
                    imageVector = Icons.Default.Home,
                    contentDescription = "HomeScreen",
                    colorFilter = ColorFilter.tint(
                        Color.White
                    ), modifier = Modifier
                        .padding(end = 16.dp, top = 16.dp)

                )
            }

            Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)){
                SearchAppBar("Search something",{},{})
            }
        }

    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    Surface {
        HomeScreen(HomeViewModel())
    }
}