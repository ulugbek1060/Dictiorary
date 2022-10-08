package com.android.dictionaryapp.date.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.dictionaryapp.date.models.Meaning
import com.android.dictionaryapp.date.models.Phonetic
import com.android.dictionaryapp.date.models.WordModel

@Entity
data class WordEntity(
   @PrimaryKey
   var word: String,
   var meanings: List<Meaning>? = listOf(),
   var phonetic: String? = "",
   var phonetics: List<Phonetic>? = listOf(),
   var sourceUrls: List<String>? = listOf()
) {
   fun toWordModel(): WordModel {
      return WordModel(
         word = word,
         meanings = meanings,
         phonetic = phonetic,
         phonetics = phonetics,
         sourceUrls = sourceUrls
      )
   }
}