package com.manta.topmarket.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.manta.topmarket.R
import com.manta.topmarket.databinding.ActivityMainBinding
import com.manta.topmarket.model.Product
import com.manta.topmarket.util.AppListAdapter
import com.manta.topmarket.util.ImageProvider
import dagger.hilt.android.AndroidEntryPoint
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

        binding.trendingToys.adapter = AppListAdapter<Product>(R.layout.item_toy_box)
        binding.recommendToys.adapter = AppListAdapter<Product>(R.layout.item_toy_row)
    }
}