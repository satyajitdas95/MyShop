package com.satyajit.myshop.data.repository

import androidx.room.Database
import com.google.gson.JsonArray
import com.satyajit.myshop.data.api.NetworkService
import com.satyajit.myshop.data.local.db.AppDatabase
import com.satyajit.myshop.data.model.AllProductsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.json.JSONArray
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SearchRepository @Inject constructor(private val networkService: NetworkService,private val databaseService:AppDatabase) {

    fun getAllProducts(): Flow<List<AllProductsResponse.Product>> {
        return flow {
            emit(networkService.getAllProducts())
        }.map {
            it.products
        }
    }

    fun getAllCategories(): Flow<JsonArray> {
        return flow {
            emit(networkService.getAllCategory())
        }
    }


}