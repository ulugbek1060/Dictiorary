package com.android.dictionaryapp.date.networkservices

import com.android.dictionaryapp.date.models.WordModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WordApiService {
   @GET("{lang}/{word}")
   suspend fun getWord(
      @Path("lang") lang: String,
      @Path("word") word: String
   ): Response<List<WordModel>>
}