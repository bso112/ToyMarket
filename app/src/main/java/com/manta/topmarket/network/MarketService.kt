package com.manta.topmarket.network

import com.manta.topmarket.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MarketService {
    @GET("/products")
    suspend fun getAllProduct() : Response<List<Product>>

    @GET("/products/{id}")
    suspend fun getProduct(@Path("id") productId : Int) : Response<Product>

    @GET("/products?limit={limit}")
    suspend fun getProductListByLimit(@Path("limit") limit : Int) : Response<List<Product>>
}