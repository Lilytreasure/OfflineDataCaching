package com.example.soko.features.productslist

import androidx.lifecycle.*
import com.example.soko.api.ProductsListApi
import com.example.soko.data.ProductList
import com.example.soko.data.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    //The repository mediates between  the database and the api
    repository: ProductsRepository


    // api: ProductsListApi
):ViewModel() {

    val products=repository.getProducts().asLiveData()


//    private val productsLiveData=MutableLiveData<List<ProductList>>()
//    val products: LiveData<List<ProductList>> = productsLiveData
//
//    init {
//      viewModelScope.launch {
//          val products=api.getProductsList()
//          delay(3000)
//          productsLiveData.value=products
//
//      }
//
//    }
//

}