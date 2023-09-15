package com.movie.data.remote.service

import com.movie.data.model.ResultsCatsModel
import retrofit2.http.GET
import retrofit2.http.Header

interface CatsService {

    @GET("3/gallery/search/?q=cats")
    suspend fun getListCats(
        @Header("authorization") Authorization: String
    ): ResultsCatsModel
}