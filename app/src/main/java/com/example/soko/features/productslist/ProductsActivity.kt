package com.example.soko.features.productslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soko.databinding.ProductsActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {


    private val viewModel:ProductsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ProductsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //add the recycler view adapter
        val productsAdapter=ProductsAdapter()

        binding.apply {
            recyclerView.apply {
                adapter=productsAdapter
                layoutManager=LinearLayoutManager(this@ProductsActivity)

            }
            viewModel.products.observe(this@ProductsActivity){products->
                productsAdapter.submitList(products)

            }

        }



//End of onCreate Method
    }


}