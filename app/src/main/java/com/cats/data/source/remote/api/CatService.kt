package com.cats.data.source.remote.api

import com.cats.data.model.CatResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CatService {

    @GET("3/gallery/search/?q=cats")
    suspend fun getListCats(
        @Header("authorization") authorization: String
    ): Response<CatResponse>
}