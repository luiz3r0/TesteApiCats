package com.movie.data.repository

import com.movie.data.model.CatsModel
import kotlinx.coroutines.flow.Flow

interface CatsRepositoryInterface {

    fun listCats(): Flow<List<CatsModel>>?
    suspend fun startDownloadApiCats()
}