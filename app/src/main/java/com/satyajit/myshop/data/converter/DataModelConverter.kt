package com.satyajit.myshop.data.converter

import com.satyajit.myshop.data.local.db.entity.Product
import com.satyajit.myshop.data.model.AllProductsResponse

object DataModelConverter {

    fun convertToDbObject(product:AllProductsResponse.Product) :Product{
        return Product(
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
}