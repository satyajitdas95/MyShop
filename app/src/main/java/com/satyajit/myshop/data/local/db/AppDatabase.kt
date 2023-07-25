package com.satyajit.myshop.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.satyajit.myshop.data.local.db.converter.Converters
import com.satyajit.myshop.data.local.db.dao.ProductDao
import com.satyajit.myshop.data.local.db.entity.Product

@Database(entities = [Product::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}