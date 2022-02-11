package com.jcortezstudio.coffe4coders.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jcortezstudio.coffe4coders.data.MockDataProvider
import com.jcortezstudio.coffe4coders.ui.components.*
import com.jcortezstudio.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun FeedScreen(navController: NavController) {
    val list = MockDataProvider.listOfProducts()
    Scaffold(topBar = {
        AppBar(title = "Coffe4Coders")
    }, content = {
        Coffe4CodersTheme {
            Surface(
                color = MaterialTheme.colors.background
            ) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        Column(modifier = Modifier.padding(8.dp)) {
                            TitleText(title = "Bienvenido")
                            BodyText(body = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
                        }
                    }
                    items(list) { product ->
                        ProductCard(
                            product = product
                        ) {
                            navController.navigate("detail/${product.id}") {
                                launchSingleTop = true
                            }
                        }
                    }
                }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    Coffe4CodersTheme() {
        FeedScreen(navController = navController)
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun FeedScreenPreviewDark() {
    val navController = rememberNavController()
    Coffe4CodersTheme() {
        FeedScreen(navController = navController)
    }
}