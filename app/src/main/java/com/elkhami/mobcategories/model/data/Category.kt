package com.elkhami.productcatalogue.data.model

data class Category(
    val description: String,
    val id: String,
    val name: String,
    val products: List<Product>
)