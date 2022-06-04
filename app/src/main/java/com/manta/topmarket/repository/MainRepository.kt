package com.manta.topmarket.repository

import com.manta.topmarket.network.MarketService
import com.manta.topmarket.network.NetworkProcessor
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val marketService: MarketService,
    private val networkProcessor: NetworkProcessor
) {

    fun fetchProductList(
        onError: suspend (Throwable) -> Unit = {}
    ) = networkProcessor.processNetwork(
        netWorkCall = { marketService.getAllProduct() },
        onError = onError
    )
}