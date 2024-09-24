package com.cats.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.cats.data.model.ImageModel

class ImageListConverterUtil {

    @TypeConverter
    fun fromString(value: String?): List<ImageModel>? {
        val listType = object : TypeToken<List<ImageModel>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<ImageModel>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}