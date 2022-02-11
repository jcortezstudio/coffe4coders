package com.jcortezstudio.coffe4coders.models

data class Product(
    val id: Int,
    val name: String,
    val summary: String,
    val description: String,
    val price: Double,
    val currency: String,
    val country: String
)
