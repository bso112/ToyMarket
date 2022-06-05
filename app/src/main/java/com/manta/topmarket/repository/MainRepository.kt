package com.manta.topmarket.repository

import com.manta.topmarket.network.MarketService
import com.manta.topmarket.util.processNetwork
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val marketService: MarketService,
    private val ioDispatcher: CoroutineDispatcher
) {
    suspend fun fetchProductList() = processNetwork(
        ioDispatcher = ioDispatcher,
        netWorkCall = { marketService.getAllProduct() }
    )

    suspend fun fetchUserName() : Result<String> {
        delay(500)
        return Result.success("Mark")
    }
}