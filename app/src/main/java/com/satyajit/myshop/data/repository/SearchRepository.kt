package com.satyajit.myshop.data.repository

import com.satyajit.myshop.data.api.NetworkService
import com.satyajit.myshop.data.local.db.AppDatabase
import com.satyajit.myshop.data.local.db.entity.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SearchRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: AppDatabase
) {

    fun getAllProducts(query: String): Flow<List<Product>> {
        return databaseService.productDao().getAllProductByName(query)
    }

}