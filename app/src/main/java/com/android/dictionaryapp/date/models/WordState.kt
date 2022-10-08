package com.android.dictionaryapp.date.models

data class WordState(
   val isLoading: Boolean = false,
   val words: List<WordModel> = emptyList(),
   val error: String = ""
)