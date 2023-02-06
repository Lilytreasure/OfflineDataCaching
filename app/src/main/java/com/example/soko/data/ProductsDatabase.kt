package com.example.soko.data

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase


@Database(entities = [ProductList::class], version = 1)
 abstract class ProductsDatabase :RoomDatabase(){

    abstract  fun productsDao(): ProductsDao


}