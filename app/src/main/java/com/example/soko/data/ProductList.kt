package com.example.soko.data

data class ProductList(
    val id: Long,
    val title: String,
    val price: Double,
    val description: String,
    val category: Category,
    val image: String,
    val rating: Rating

)
