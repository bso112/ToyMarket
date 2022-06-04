package com.manta.topmarket.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

sealed class NetWorkException(msg: String? = null) : Throwable(msg)
data class InvalidResponseException(val invalidData: Any) : NetWorkException(invalidData.toString())
data class HttpStatusException(val statusCode: Int) : NetWorkException("[statusCode : $statusCode]")
class NullResponseException() : NetWorkException()

@Singleton
class NetworkProcessor @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher
) {

    fun <T : Any> processNetwork(
        netWorkCall: suspend () -> Response<T>,
        dataValidator: (T) -> Boolean = { true },
        onStart: () -> Unit = {},
        onComplete: suspend () -> Unit = {},
        onError: suspend (Throwable) -> Unit = {}
    ) = flow {
        kotlin.runCatching {
            val response = netWorkCall()
            val body = response.body() ?: throw NullResponseException()
            if (response.isSuccessful) {
                if (dataValidator(body)) {
                    emit(body)
                } else {
                    onError(InvalidResponseException(body))
                }
            } else {
                onError(HttpStatusException(response.code()))
            }
        }.onFailure {
            onError(it)
        }
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(ioDispatcher)

}