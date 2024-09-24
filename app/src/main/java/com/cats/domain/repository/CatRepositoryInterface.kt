package com.cats.domain.repository

import com.cats.data.source.local.db.entities.CatEntity
import kotlinx.coroutines.flow.Flow

interface CatRepositoryInterface {

    fun getCats(): Flow<List<CatEntity>>?
    suspend fun downloadCatsFromApi()
}