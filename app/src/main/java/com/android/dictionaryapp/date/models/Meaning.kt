package com.android.dictionaryapp.date.models

import com.google.gson.annotations.SerializedName


data class Meaning(
   @SerializedName("antonyms")
   var antonyms: List<Any?>? = null,
   @SerializedName("definitions")
   var definitions: List<Definition?>? = null,
   @SerializedName("partOfSpeech")
   var partOfSpeech: String? = null,
   @SerializedName("synonyms")
   var synonyms: List<String?>? = null
)