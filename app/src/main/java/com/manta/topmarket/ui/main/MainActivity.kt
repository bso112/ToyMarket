package com.manta.topmarket.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.manta.topmarket.R
import com.manta.topmarket.databinding.ActivityMainBinding
import com.manta.topmarket.databinding.ItemToyBoxBinding
import com.manta.topmarket.databinding.ItemToyRowBinding
import com.manta.topmarket.model.Product
import com.manta.topmarket.ui.ProductDetailActivity
import com.manta.topmarket.util.AppListAdapter
import com.manta.topmarket.util.ImageProvider
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private val vm: MainViewModel by viewModels()

    @Inject
    lateinit var imageProvider: ImageProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.vm = vm

        binding.trendingToys.adapter =
            object : AppListAdapter<Product, ItemToyBoxBinding>(R.layout.item_toy_box) {
                override fun onBindViewHolder(
                    holder: ViewHolder<ItemToyBoxBinding>,
                    position: Int
                ) {
                    val product = getItem(position)
                    holder.binding.apply {
                        imageProvider.loadImage(productImg, product.image)
                        productName.text = product.title
                        price.text = "$${product.price}"

                    }
                }
            }

        binding.recommendToys.adapter = object : AppListAdapter<Product, ItemToyRowBinding>(R.layout.item_toy_row){
            override fun onBindViewHolder(holder: ViewHolder<ItemToyRowBinding>, position: Int) {
                val product = getItem(position)
                holder.binding.apply {
                    imageProvider.loadImage(productImg, product.image)
                    productName.text = product.title
                    price.text = "$${product.price}"
                }
            }

        }
    }
}