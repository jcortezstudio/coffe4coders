package com.jcortezstudio.coffe4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jcortezstudio.coffe4coders.data.MockDataProvider
import com.jcortezstudio.coffe4coders.ui.screens.CheckoutScreen
import com.jcortezstudio.coffe4coders.ui.screens.DetailScreen
import com.jcortezstudio.coffe4coders.ui.screens.FeedScreen
import com.jcortezstudio.coffe4coders.ui.theme.Coffe4CodersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    Coffe4CodersTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(navController = navController, startDestination = "feed") {
                composable(route = "feed") {
                    FeedScreen(navController = navController)
                }
                composable(route = "detail/{id}") { backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("id") ?: "0"
                    val id = productIdString.toInt()
                    val product = MockDataProvider.getProductById(id)
                    DetailScreen(navController = navController, product = product!!)
                }
                composable(route = "checkout/{id}") { backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("id") ?: "0"
                    val id = productIdString.toInt()
                    val product = MockDataProvider.getProductById(id)
                    CheckoutScreen(navController = navController, product = product!!)
                }
            }
        }
    }
}