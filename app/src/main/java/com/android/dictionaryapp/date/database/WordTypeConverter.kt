package com.android.dictionaryapp.date.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.android.dictionaryapp.date.models.Meaning
import com.android.dictionaryapp.date.models.Phonetic
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
object WordTypeConverter {

   private val gson = Gson()

   @TypeConverter
   fun meaningsFromJson(str: String): List<Meaning> {
      return gson.fromJson(str, object : TypeToken<List<Meaning>>() {}.type)
   }

   @TypeConverter
   fun meaningsToJson(list: List<Meaning>): String {
      return gson.toJson(list)
   }

   @TypeConverter
   fun phoneticFromJson(str: String): List<Phonetic> {
      return gson.fromJson(str, object : TypeToken<List<Phonetic>>() {}.type)
   }

   @TypeConverter
   fun phoneticToJson(list: List<Phonetic>): String {
      return gson.toJson(list)
   }

   @TypeConverter
   fun sourceUrlFromJson(str: String): List<String> {
      return gson.fromJson(str, object : TypeToken<List<String>>() {}.type)
   }

   @TypeConverter
   fun sourceUrlToJson(list: List<String>): String {
      return gson.toJson(list)
   }
}