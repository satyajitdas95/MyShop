package com.satyajit.myshop.data.local.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.satyajit.myshop.data.local.db.entity.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert
    fun insertAll(products: List<Product>)

    @Insert
    fun insert(product: Product)

    @Query("DELETE from product")
    fun deleteAll()

    @Delete
    fun delete(product: Product)

    @Update
    fun update(product: Product)

    @Query("SELECT * FROM product WHERE title LIKE '%' || :query || '%'")
    fun getAllProductByName(query: String): Flow<List<Product>>

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<Product>>

    @Query("SELECT * FROM product where id = :productId")
    fun getProductByID(productId:Int): Flow<Product>

}