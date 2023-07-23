package com.satyajit.myshop.data.repository

import com.satyajit.myshop.data.api.NetworkService
import com.satyajit.myshop.data.model.AllProductsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HomeRepository @Inject constructor(private val networkService: NetworkService) {

     fun getAllProducts() : Flow<List<AllProductsResponse.Product>>{
        return flow {
            emit(networkService.getAllProducts())
        }.map {
            it.products
        }

    }


}