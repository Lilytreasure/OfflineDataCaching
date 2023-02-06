package com.example.soko.features.productslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soko.api.ProductsListApi
import com.example.soko.data.ProductList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    api: ProductsListApi
):ViewModel() {


    private val productsLiveData=MutableLiveData<List<ProductList>>()
    val products: LiveData<List<ProductList>> = productsLiveData

    init {
      viewModelScope.launch {
          val products=api.getProductsList()
          delay(3000)
          productsLiveData.value=products

      }

    }


}