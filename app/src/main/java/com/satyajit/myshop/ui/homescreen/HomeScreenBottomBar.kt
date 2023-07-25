package com.satyajit.myshop.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satyajit.myshop.R

@Composable
fun HomeScreenBottomBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 16.dp)
    ) {

        Text(
            text = stringResource(id = R.string.label_shop_details),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Image(
              imageVector = Icons.Default.LocationOn,
                contentDescription = "Shop Thumbnail",
                modifier = Modifier.padding(top = 12.dp).size(20.dp).alpha(0.5f),
            )

            Text(
                text = stringResource(id = R.string.label_shop_details_location),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f), modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            )

        }


        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Image(
                imageVector = Icons.Default.Call,
                contentDescription = "Shop Thumbnail",
                modifier = Modifier.padding(top = 12.dp).size(20.dp).alpha(0.5f),
            )

            Text(
                text = stringResource(id = R.string.label_shop_details_payment),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f), modifier = Modifier.padding(top = 10.dp, start = 10.dp)
            )

        }

    }
}

@Preview
@Composable
fun PreviewHomeScreenTopBar() {
    Surface {
        HomeScreenBottomBar()
    }

}