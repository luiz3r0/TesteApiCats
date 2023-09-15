package com.movie.data.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.movie.data.db.dao.CatsDao
import com.movie.data.model.CatsModel
import com.movie.util.ImageListConverterUtil

@Database(entities = [CatsModel::class], version = 2, exportSchema = false)
@TypeConverters(ImageListConverterUtil::class)
abstract class CatsDatabase: RoomDatabase() {

    abstract val catsDao: CatsDao

    companion object {

        @Volatile
        private var INSTANCE: CatsDatabase? = null

        fun getInstance(context: Context): CatsDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CatsDatabase::class.java,
                    "catsdatabase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}