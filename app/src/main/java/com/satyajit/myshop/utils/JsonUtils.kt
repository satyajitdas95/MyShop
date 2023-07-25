package com.satyajit.myshop.utils

import com.google.gson.JsonArray

object JsonUtils {
    fun convertJsonArrayToStringArray(jsonArray: JsonArray): MutableList<String> {
        val outputArray = mutableListOf<String>()
        jsonArray.forEach { element ->
            outputArray.add(element.toString())
        }

        return outputArray
    }
}