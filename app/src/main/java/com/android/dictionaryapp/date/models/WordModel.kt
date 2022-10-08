package com.android.dictionaryapp.date.models


import com.android.dictionaryapp.date.entities.WordEntity
import com.google.gson.annotations.SerializedName

data class WordModel(
   @SerializedName("meanings")
   var meanings: List<Meaning>? = listOf(),
   @SerializedName("phonetic")
   var phonetic: String? = "",
   @SerializedName("phonetics")
   var phonetics: List<Phonetic>? = listOf(),
   @SerializedName("sourceUrls")
   var sourceUrls: List<String>? = listOf(),
   @SerializedName("word")
   var word: String? = ""
) {
   fun toWordEntity(): WordEntity {
      return WordEntity(
         word = word ?: "Undefined word",
         meanings = meanings,
         phonetic = phonetic,
         phonetics = phonetics,
         sourceUrls = sourceUrls
      )
   }
}