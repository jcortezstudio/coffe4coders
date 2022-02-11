package com.jcortezstudio.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
fun CheckoutScreen(navController: NavController, product: Product) {
    val cities = listOf(
        "Ciudad de México, México",
        "La Habana, Cuba",
        "Cancún, México",
        "Medellín, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Perú",
        "Montevideo, Uruguay",
        "Ciudad de Panamá, Panamá"
    )
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    /*CustomTextField(value = name, placeholder = "Nombre") {
        name = it
    }*/

    Scaffold(
        topBar = {
            AppBar(navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate("detail/${product.id}")
            }
        },
        content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ProductCard(
                    product = product
                ) {}

                Column(modifier = Modifier.padding(15.dp)) {
                    CustomTextField(value = name, placeholder = "Nombre completo") {
                        name = it
                    }
                    CustomTextField(value = email, placeholder = "Correo electrónico") {
                        email = it
                    }
                    CustomTextField(value = phone, placeholder = "Telefóno") {
                        phone = it
                    }
                    CustomTextField(value = address, placeholder = "Dirección") {
                        address = it
                    }
                    DropdownTexField(suggestions = cities, value = city, placeholder = "Ciudad") {
                        city = it
                    }

                    Column {
                        Row {
                            Text(text = "SubTotal", style = MaterialTheme.typography.caption)
                            Text(
                                text = "$ 35.0 USD",
                                style = MaterialTheme.typography.body2,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End
                            )
                        }
                        Row {
                            Text(text = "Envio", style = MaterialTheme.typography.caption)
                            Text(
                                text = "$ 10.0 USD",
                                style = MaterialTheme.typography.body2,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.End
                            )
                        }
                    }

                    Row(horizontalArrangement = spacedBy(16.dp)) {
                        Text(
                            text = "$ 45.0 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start
                        )
                        CustomButton(label = "Finalizar pedido") {

                        }
                    }
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    val product = MockDataProvider.getProductById(0)
    if(product != null){
        val navController = rememberNavController()
        Coffe4CodersTheme {
            CheckoutScreen(navController = navController, product = product)
        }
    }
}