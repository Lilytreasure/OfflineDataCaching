package com.example.soko.data

import androidx.room.withTransaction
import com.example.soko.api.ProductsListApi
import com.example.soko.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ProductsRepository @Inject constructor(
    private val api: ProductsListApi,
    private val db: ProductsDatabase,


) {

    //populate data from the database

    private val productsDao=db.productsDao()
    fun getProducts()= networkBoundResource(
        query = {
            productsDao.getAllProducts()

        },
        fetch = {
            delay(3000)
            api.getProductsList()
        },
        saveFetchResult ={ products->

            //all operations has  to pass or none will be executed
            //To avoid clearing the database  without inserting data

            db.withTransaction {
                productsDao.deleteAllProducts()
                productsDao.insertProducts(products)
            }
        }

    )


}