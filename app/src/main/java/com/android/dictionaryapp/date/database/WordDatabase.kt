package com.android.dictionaryapp.date.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.dictionaryapp.date.entities.WordEntity

@Database(
   entities = [WordEntity::class],
   version = 1,
   exportSchema = false
)
@TypeConverters(WordTypeConverter::class)
abstract class WordDatabase : RoomDatabase() {
   abstract val dictionaryDao: WordDao
}