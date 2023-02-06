package com.example.soko.api

import com.example.soko.data.ProductList
import retrofit2.http.GET

interface ProductsListApi {


    companion object{
        const val BASE_URL="https://fakestoreapi.com/"
    }

    //Get request

    @GET("products")
    suspend fun getProductsList():List<ProductList>




}