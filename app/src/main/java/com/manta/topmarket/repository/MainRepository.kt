package com.manta.topmarket.repository

import com.manta.topmarket.network.MarketService
import com.manta.topmarket.util.processNetwork
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val marketService: MarketService,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun fetchProductList() = processNetwork(
        ioDispatcher = ioDispatcher,
        netWorkCall = { marketService.getAllProduct() }
    )
}