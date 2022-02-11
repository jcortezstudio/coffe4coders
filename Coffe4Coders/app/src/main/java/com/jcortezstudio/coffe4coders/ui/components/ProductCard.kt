package com.jcortezstudio.coffe4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jcortezstudio.coffe4coders.R
import com.jcortezstudio.coffe4coders.data.MockDataProvider
import com.jcortezstudio.coffe4coders.models.Product
import com.jcortezstudio.coffe4coders.ui.theme.Coffe4CodersTheme
import com.jcortezstudio.coffe4coders.ui.theme.PlatziBlue
import com.jcortezstudio.coffe4coders.ui.theme.PlatziGreen

enum class CountryISO(val iso: String) {
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgroundImage(): Int {
        return when (this) {
            COL -> R.drawable.co
            BRA -> R.drawable.br
            CRI -> R.drawable.ri
            NIC -> R.drawable.ni

        }
    }

    fun getCountryFlagImage(): Int {
        return when (this) {
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni

        }
    }

    fun getSurfaceColor(): Color {
        return when (this) {
            COL -> PlatziBlue
            BRA -> PlatziGreen
            CRI -> PlatziGreen
            NIC -> PlatziBlue
        }
    }
}

typealias SelectionAction = () -> Unit

@Composable
fun ProductCard(
    product: Product,
    selected: SelectionAction
) {
    val country = CountryISO.valueOf(product.country)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                selected()
            }
            .size(480.dp),
        elevation = 10.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            painter = painterResource(id = country.getBackgroundImage()),
            contentDescription = null
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.getSurfaceColor().copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(15.dp)
            ) {
                Text(product.name, style = MaterialTheme.typography.h4)
                Text(
                    product.summary,
                    style = MaterialTheme.typography.body1
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = country.getCountryFlagImage()),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    val product = MockDataProvider.getProductById(0)
    if(product != null){
        Coffe4CodersTheme {
            ProductCard(product = product) {}
        }
    }
}