package com.movie.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.movie.data.model.Image

class ImageListConverterUtil {

    @TypeConverter
    fun fromString(value: String?): List<Image>? {
        val listType = object : TypeToken<List<Image>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(list: List<Image>?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }
}