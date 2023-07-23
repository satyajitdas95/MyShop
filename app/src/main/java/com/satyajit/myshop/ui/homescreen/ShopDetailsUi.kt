import androidx.compose.foundation.Image
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
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satyajit.myshop.R
import com.satyajit.myshop.ui.custom.DrawHorizontalDashLine


@Composable
fun ShopDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(all = 16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_demo_shop_thumb),
                contentDescription = "Shop Thumbnail",
                modifier = Modifier.size(60.dp)
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = stringResource(id = R.string.label_shop_name),
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text = stringResource(id = R.string.label_shop_category),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.alpha(ContentAlpha.medium)
                    )

                    Text(
                        text = stringResource(id = R.string.label_shop_read_my_story).toUpperCase(
                            Locale.current
                        ),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 16.dp),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_foward_arrow),
                        contentDescription = "Shop Thumbnail",
                        modifier = Modifier.size(20.dp),
                    )
                }

            }

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "Shop Thumbnail",
                modifier = Modifier.size(24.dp),
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        DrawHorizontalDashLine(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.label_shop_store_timing_value),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                )

                Text(
                    text = stringResource(id = R.string.label_shop_store_timing),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.label_shop_delivery_timing_value),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                )

                Text(
                    text = stringResource(id = R.string.label_shop_delivery_timing),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.label_shop_minimum_order_value),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                )

                Text(
                    text = stringResource(id = R.string.label_shop_minimum_order),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )
            }

        }

        Spacer(modifier = Modifier.height(12.dp))

        DrawHorizontalDashLine(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = "RAting",
                    modifier = Modifier.size(24.dp),
                )

                Text(
                    text = stringResource(id = R.string.label_shop_rating),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary

                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = "distacne",
                    modifier = Modifier.size(24.dp),
                )

                Text(
                    text = stringResource(id = R.string.label_shop_distance_value),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary

                )
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 2.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_contact),
                    contentDescription = "Contact",
                    modifier = Modifier.size(24.dp),
                )

                Text(
                    text = stringResource(id = R.string.label_shop_contact),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 2.dp)

                )
            }
        }

    }
}

@Preview
@Composable
fun PreviewShopDetails() {
    Surface {
        ShopDetails()
    }
}