package com.satyajit.myshop.data.api

import com.google.gson.JsonArray
import com.satyajit.myshop.data.model.AllProductsResponse
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET("products")
    suspend fun getAllProducts() : AllProductsResponse

    @GET("products")
    suspend fun getAllCategory() : JsonArray

}