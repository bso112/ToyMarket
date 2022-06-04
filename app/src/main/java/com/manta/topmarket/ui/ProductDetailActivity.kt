package com.manta.topmarket.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.manta.topmarket.R
import com.manta.topmarket.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private val binding : ActivityProductDetailBinding by lazy{
        DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding


    }
}