package com.satyajit.myshop.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(
    @PrimaryKey val id: Int,
    @ColumnInfo("title") var title: String,
    @ColumnInfo("description") var description: String,
    @ColumnInfo("price") var price: Int,
    @ColumnInfo("discountPercentage") var discountPercentage: Double,
    @ColumnInfo("rating") var rating: Double,
    @ColumnInfo("stock") var stock: Int,
    @ColumnInfo("brand") var brand: String,
    @ColumnInfo("category") var category: String,
    @ColumnInfo("thumbnail") var thumbnail: String,
)

