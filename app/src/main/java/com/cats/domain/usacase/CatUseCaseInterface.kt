package com.cats.domain.usacase

import com.cats.data.source.local.db.entities.CatEntity
import kotlinx.coroutines.flow.Flow

interface CatUseCaseInterface {

    fun getCats(): Flow<List<CatEntity>>?
    suspend fun downloadCatsFromApi()
}