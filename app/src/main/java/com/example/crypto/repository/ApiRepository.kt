package com.example.crypto.repository


import com.example.crypto.api.ApiServices
import com.example.crypto.utils.DataStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiServices: ApiServices) {
    suspend fun getCoinsList(vs_currency: String) = flow {
        emit(DataStatus.loading())
        val result = apiServices.getCoinsList(vs_currency)
        when (result.code()) {
            200 -> emit(DataStatus.success(result.body()))
            400 -> emit(DataStatus.error(result.message()))
            500 -> emit(DataStatus.error(result.message()))
        }
    }.catch {
        emit(DataStatus.error(it.message.toString()))
    }
        .flowOn(Dispatchers.IO)

    suspend fun getDetailsCoin(id: String) = flow {
        val result = apiServices.getDetailsCoin(id)
        when (result.code()) {
            200 -> emit(DataStatus.success(result.body()))
            400 -> emit(DataStatus.error(result.message()))
            500 -> emit(DataStatus.error(result.message()))
        }
    }
        .catch {
            emit(DataStatus.error(it.message.toString()))
        }
        .flowOn(Dispatchers.IO)
}