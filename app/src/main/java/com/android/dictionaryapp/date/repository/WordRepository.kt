package com.android.dictionaryapp.date.repository

import com.android.dictionaryapp.date.database.WordDatabase
import com.android.dictionaryapp.date.entities.WordEntity
import com.android.dictionaryapp.date.networkservices.WordApiService
import com.android.dictionaryapp.utils.Consts.DEFAULT_ERROR_CODE
import com.android.dictionaryapp.utils.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WordRepository @Inject constructor(
   private val database: WordDatabase,
   private val apiService: WordApiService
) {

   fun getWord(lang: String, word: String) = flow {
      try {
         coroutineScope {
            emit(ResponseState.Loading)
            val response = apiService.getWord(lang, word)
            if (response.isSuccessful) {
               val list = response.body() ?: emptyList()
               emit(ResponseState.Success(list))
            } else {
               val message = response.message()
               val code = response.code()
               emit(ResponseState.Fail(message, code))
            }
         }
      } catch (e: IOException) {
         emit(ResponseState.Fail("Check the internet connection!", DEFAULT_ERROR_CODE))
      } catch (e: HttpException) {
         emit(ResponseState.Fail(e.message ?: "OooPs Something went wrong", e.code()))
      }
   }.flowOn(Dispatchers.IO)

   suspend fun insertWordList(list: List<WordEntity>) {
      database.dictionaryDao.inset(list)
   }

   suspend fun insetWord(wordEntity: WordEntity) {
      database.dictionaryDao.inset(wordEntity)
   }

   suspend fun deleteWord(word: String) {
      database.dictionaryDao.deleteWord(word)
   }

   fun getWordList(): Flow<List<WordEntity>> {
      return database.dictionaryDao.getAllWords()
   }
}