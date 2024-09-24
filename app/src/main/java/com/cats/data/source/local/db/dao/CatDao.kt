package com.cats.data.source.local.db.dao

import androidx.room.*
import com.cats.data.source.local.db.entities.CatEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CatDao {

    @Query("SELECT * FROM catmodel")
    fun getAllCats(): Flow<List<CatEntity>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCats(cats: List<CatEntity>)

    @Query("DELETE FROM catmodel")
    suspend fun clearAllCats()
}