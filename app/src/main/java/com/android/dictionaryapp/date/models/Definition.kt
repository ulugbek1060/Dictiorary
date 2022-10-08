package com.android.dictionaryapp.date.models

import com.google.gson.annotations.SerializedName

data class Definition(
   @SerializedName("antonyms")
   var antonyms: List<Any?>? = null,
   @SerializedName("definition")
   var definition: String? = null,
   @SerializedName("synonyms")
   var synonyms: List<Any?>? = null
)