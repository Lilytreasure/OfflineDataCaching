package com.example.soko.features.productslist


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soko.data.ProductList
import com.example.soko.databinding.ProductsItemsBinding

class ProductsAdapter: ListAdapter<ProductList, ProductsAdapter.ProductsViewHolder>(ProductListComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {

        //inflate the view
        val binding=ProductsItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductsViewHolder(binding)


    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val currentItem=getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }

    }



//Products ViewHolder
    class ProductsViewHolder(private val binding:ProductsItemsBinding ):
        RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bind(productList: ProductList){
            binding.apply {

               txtTitle.text=productList.title
                textPrice.text="$"+productList.price.toString()
                textDescription.text=productList.description

                //maPing the image on the imageView using Glide
                val url:String=productList.image
                Glide.with(itemView)
                    .load(url)
                    .into(imageView)

            }

        }


    }

    //comparator class--checks simmilarity between old and new data
    //Referenced by the id


    class ProductListComparator: DiffUtil.ItemCallback<ProductList>(){
        override fun areItemsTheSame(oldItem: ProductList, newItem: ProductList)=
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ProductList, newItem: ProductList)=
            oldItem==newItem

    }




}