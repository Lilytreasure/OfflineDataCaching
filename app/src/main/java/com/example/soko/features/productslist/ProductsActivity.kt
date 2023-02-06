package com.example.soko.features.productslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soko.databinding.ProductsActivityBinding
import com.example.soko.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
//Cache data in room db

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
            viewModel.products.observe(this@ProductsActivity){result->
            productsAdapter.submitList(result.data)


                //User error Notifier


                LoadProgress.isVisible =result is Resource.Loading && result.data.isNullOrEmpty()
                TextError.isVisible =result is Resource.Error && result.data.isNullOrEmpty()
                TextError.text=result.error?.localizedMessage


            }

        }



//End of onCreate Method
    }


}