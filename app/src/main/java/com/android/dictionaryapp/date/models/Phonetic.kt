package com.android.dictionaryapp.date.models

import com.google.gson.annotations.SerializedName


data class Phonetic(
   @SerializedName("audio")
   var audio: String? = "",
   @SerializedName("sourceUrl")
   var sourceUrl: String? = "",
   @SerializedName("text")
   var text: String? = ""
)