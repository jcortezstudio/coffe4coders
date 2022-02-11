package com.jcortezstudio.coffe4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jcortezstudio.coffe4coders.data.MockDataProvider
import com.jcortezstudio.coffe4coders.models.Product
import com.jcortezstudio.coffe4coders.ui.components.*
import com.jcortezstudio.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun DetailScreen(navController: NavController, product: Product) {
    val country = CountryISO.valueOf(product.country)
    Scaffold(topBar = {
        AppBar(navigationIcon = Icons.Filled.ArrowBack) {
            navController.navigate(route = "feed") {
                popUpTo("feed")
            }
        }
    }, content = {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                Image(
                    painter = painterResource(id = country.getBackgroundImage()),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                TitleText(title = product.name)
                Text(
                    text = product.summary,
                    style = MaterialTheme.typography.caption
                )
                Spacer(modifier = Modifier.height(24.dp))
                BodyText(body = product.description)
                Spacer(modifier = Modifier.height(24.dp))
                Row(horizontalArrangement = spacedBy(16.dp)) {
                    Text(
                        text = "$ ${product.price} ${product.currency}",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.End
                    )
                    CustomButton(label = "Continuar") {
                        navController.navigate("checkout/${product.id}") {
                            launchSingleTop = true
                        }
                    }
                }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    val product = MockDataProvider.getProductById(0)
    if (product != null) {
        val navController = rememberNavController()
        Coffe4CodersTheme() {
            DetailScreen(navController = navController, product = product)
        }
    }
}