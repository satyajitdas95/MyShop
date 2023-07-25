package com.satyajit.myshop.data.repository

import com.satyajit.myshop.data.api.NetworkService
import com.satyajit.myshop.data.local.db.AppDatabase
import com.satyajit.myshop.data.local.db.entity.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HomeRepository @Inject constructor(
    private val networkService: NetworkService,
    private val database: AppDatabase
) {

    suspend fun getAllProducts(): Flow<List<Product>> {
        return flow {
            emit(networkService.getAllProducts())
        }.flatMapConcat { networkResponse ->
            return@flatMapConcat flow { emit(database.productDao().deleteAll()) }
                .flatMapConcat {
                    val productList = networkResponse.products.map { product ->
                        Product(
                            id = product.id,
                            title = product.title ?: "",
                            description = product.description ?: "",
                            price = product.price ?: 0,
                            discountPercentage = product.discountPercentage ?: 0.0,
                            rating = product.rating ?: 0.0,
                            stock = product.stock ?: 0,
                            brand = product.brand ?: "",
                            category = product.category ?: "",
                            thumbnail = product.thumbnail ?: "",
                        )
                    }
                    return@flatMapConcat flow { emit(database.productDao().insertAll(productList)) }
                }
        }
            .flatMapConcat {
                return@flatMapConcat database.productDao().getAllProducts()
            }
    }
}




