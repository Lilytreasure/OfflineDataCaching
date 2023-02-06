package com.example.soko.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Query(value = "SELECT ALL * FROM  products")
    //Flow will keep emitting data to make appropriate updates
    fun getAllProducts(): Flow<List<ProductList>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertProducts(quotes: List<ProductList>)

    @Query(value = "DELETE  FROM products")
    suspend fun  deleteAllProducts()


}