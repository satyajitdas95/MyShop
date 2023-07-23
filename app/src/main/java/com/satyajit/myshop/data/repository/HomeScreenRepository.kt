package com.satyajit.myshop.data.repository

import com.satyajit.myshop.data.api.NetworkService
import com.satyajit.myshop.data.model.AllProductResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeScreenRepository @Inject constructor(private val networkService: NetworkService) {

    fun getAllPRoducts(): Flow<AllProductResponse> {
        return flow {
            emit(networkService.getAllProducts())
        }.map {
            it
        }
    }


}