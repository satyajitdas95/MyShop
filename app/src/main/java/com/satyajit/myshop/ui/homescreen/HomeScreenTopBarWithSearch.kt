package com.satyajit.myshop.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satyajit.myshop.R

@Composable
fun HomeScreenTopHeader(onSearchClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                imageVector = Icons.Default.Home,
                contentDescription = "HomeScreen",
                colorFilter = ColorFilter.tint(
                    Color.White
                ), modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .size(20.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = "HomeScreen",
                colorFilter = ColorFilter.tint(
                    Color.White
                ), modifier = Modifier
                    .padding(end = 16.dp, top = 16.dp)
                    .size(20.dp)

            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        ) {
            SearchAppBarComponent(
                onSearchClicked = onSearchClicked,
                placeholderText = stringResource(id = R.string.label_search_placeholder),
            )
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBarComponent(
    onSearchClicked: () -> Unit,
    placeholderText: String,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(8)
            )
            .padding(start = 16.dp, end = 16.dp)
            .clickable(enabled = true) {
                onSearchClicked.invoke()
            }, verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            modifier = Modifier
                .alpha(ContentAlpha.disabled),
            text = placeholderText,
            color = Color.Black,
            fontSize = 12.sp
        )
    }
}


@Preview
@Composable
fun PreviewHomeScreenSearch() {
    Surface {
        HomeScreenTopHeader {}
    }
}

