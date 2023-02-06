package com.example.soko.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductList(
    @PrimaryKey val id: Long,
    val title: String,
    val price: Double,
    val description: String,
    //val category: Category,
    val image: String,
    //val rating: Rating

)
