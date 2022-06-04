package com.manta.topmarket.repository

import com.manta.topmarket.network.MarketService
import com.manta.topmarket.util.NullResponseException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val marketService: MarketService,
    private val ioDispatcher: CoroutineDispatcher
) {

    fun fetchProductList(
        onError: suspend (Throwable) -> Unit
    ) = flow {
        kotlin.runCatching {
            val response = marketService.getAllProduct()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                emit(body)
            } else {
                onError(NullResponseException())
            }
        }.onFailure {
            onError(it)
        }
    }.flowOn(ioDispatcher)
}