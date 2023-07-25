package com.satyajit.myshop.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.satyajit.myshop.data.local.db.dao.ProductDao
import com.satyajit.myshop.data.local.db.entity.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}