package com.android.dictionaryapp.di

import com.android.dictionaryapp.BuildConfig.BASE_URL
import com.android.dictionaryapp.date.networkservices.WordApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

   @Provides
   @Singleton
   fun providesRetrofit(): Retrofit {
      return Retrofit
         .Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
         .build()
   }

   @Provides
   @Singleton
   fun providesWordApiService(retrofit: Retrofit): WordApiService {
      return retrofit.create(WordApiService::class.java)
   }

}