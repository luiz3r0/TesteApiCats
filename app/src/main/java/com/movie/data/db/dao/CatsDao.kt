package com.movie.data.db.dao

import androidx.room.*
import com.movie.data.model.CatsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CatsDao {

    @Query("SELECT * FROM catsmodel")
    fun allCats(): CatsModel?

    @Query("SELECT * FROM catsmodel")
    fun listCats(): Flow<List<CatsModel>>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCats(catsModel: List<CatsModel>?)

    @Update
    fun updateCats(catsModel: List<CatsModel>?)
}