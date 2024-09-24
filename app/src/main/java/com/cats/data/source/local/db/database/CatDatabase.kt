package com.cats.data.source.local.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cats.data.source.local.db.dao.CatDao
import com.cats.data.source.local.db.entities.CatEntity
import com.cats.util.ImageListConverterUtil

@Database(entities = [CatEntity::class], version = 6, exportSchema = false)
@TypeConverters(ImageListConverterUtil::class)
abstract class CatDatabase : RoomDatabase() {
    abstract val catDao: CatDao
}