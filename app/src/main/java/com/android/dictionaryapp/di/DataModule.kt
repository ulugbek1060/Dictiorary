package com.android.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.android.dictionaryapp.date.database.WordDao
import com.android.dictionaryapp.date.database.WordDatabase
import com.android.dictionaryapp.utils.Consts.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

   @Provides
   @Singleton
   fun providesWordDatabase(app: Application): WordDatabase {
      return Room.databaseBuilder(app, WordDatabase::class.java, DATABASE_NAME).build()
   }

   @Provides
   @Singleton
   fun providesWordDao(wordDatabase: WordDatabase): WordDao {
      return wordDatabase.dictionaryDao
   }

}