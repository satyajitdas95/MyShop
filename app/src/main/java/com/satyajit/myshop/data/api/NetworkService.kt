package com.satyajit.myshop.data.api

import com.satyajit.myshop.data.model.AllProductResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET("products")
    suspend fun getAllProducts() : AllProductResponse

}