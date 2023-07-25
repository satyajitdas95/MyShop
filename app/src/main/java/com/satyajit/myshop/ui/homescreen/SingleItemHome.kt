package com.satyajit.myshop.ui.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.satyajit.myshop.R
import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.data.model.AllProductsResponse


@Composable
fun SingleProductItem(product: Product) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .height(250.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                shape = RoundedCornerShape(6.dp)
            )
            .background(color = MaterialTheme.colorScheme.background)
    ) {
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
                modifier = Modifier.height(40.dp),
                text = product.title ?: "N/A",
                style = MaterialTheme.typography.bodyMedium, maxLines = 2
            )

            Spacer(modifier = Modifier.height(6.dp))


            Text(
                text = "${stringResource(id = R.string.label_rupees_symbol)}${product.price.toString()}",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(6.dp))

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

}

//@Composable
//fun SingleCategoryITem(categoryName: String) {
//Box(modifier = Modifier.height(70.dp).width(110.dp).background(color = ))
//}


@Preview
@Composable
fun PreviewShopDetails() {
    Surface {
//        val testPRoduct = Product(id=1)
//        SingleProductItem(testPRoduct)
    }
}

@Preview
@Composable
fun previewCategory() {
    PreviewShopDetails()
}