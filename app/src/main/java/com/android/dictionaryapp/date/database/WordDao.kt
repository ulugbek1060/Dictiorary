package com.android.dictionaryapp.date.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.android.dictionaryapp.date.entities.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

   @Insert(onConflict = REPLACE)
   suspend fun inset(list: List<WordEntity>)

   @Insert(onConflict = REPLACE)
   suspend fun inset(wordEntity: WordEntity)

   @Query("DELETE FROM WORDENTITY WHERE word =:word")
   suspend fun deleteWord(word: String)

   @Query("SELECT * FROM WORDENTITY")
   fun getAllWords(): Flow<List<WordEntity>>

}