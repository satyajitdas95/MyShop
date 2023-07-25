package com.satyajit.myshop.ui.productdetailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.satyajit.myshop.R
import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.ui.base.UiState
import com.satyajit.myshop.ui.custom.showErrorMessageWithRetry
import com.satyajit.myshop.ui.custom.showLoading

@Composable
fun ProductDetailsScreen(
    uiStateProduct: UiState<Product>, onClickOfBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = MaterialTheme.colorScheme.primary),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "HomeScreen",
                colorFilter = ColorFilter.tint(
                    Color.White
                ), modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .size(20.dp)
                    .clickable { onClickOfBack.invoke() }
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

        when (uiStateProduct) {

            is UiState.Loading -> {
                if(uiStateProduct.isLoading){
                    showLoading()
                }
            }

            is UiState.Error -> {
                showErrorMessageWithRetry(
                    stringResource(id = R.string.error_no_result_found),
                    {}
                )
            }

            is UiState.Success -> {
                PRoductAllDetailsUi(uiStateProduct.data)
            }
        }


    }
}

@Composable
fun PRoductAllDetailsUi(product: Product) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .background(color = MaterialTheme.colorScheme.background)
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(product.thumbnail)
                .crossfade(true).build(),
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight(fraction = 0.45f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier.wrapContentHeight(),
            text = product.title,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(6.dp))


        Text(
            text = "${stringResource(id = R.string.label_rupees_symbol)}${product.price}",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                textAlign = TextAlign.Center,
                text = "1 Unit",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Text(
                textAlign = TextAlign.Center,
                text = "2 Unit",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(4.dp)
                    )
            )

            Text(
                textAlign = TextAlign.Center,
                text = "3 Unit",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(4.dp)
                    )
            )
        }


        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(4.dp)
                ),
            textAlign = TextAlign.Center,
            text = "Add",
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary

        )
    }
}

@Preview
@Composable
fun ProductDetailsPreview() {
//    ProductDetailsScreen(Product(1, "Hello")) {}
}
