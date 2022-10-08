package com.android.dictionaryapp.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.dictionaryapp.date.models.WordModel
import com.android.dictionaryapp.date.models.WordState
import com.android.dictionaryapp.date.repository.WordRepository
import com.android.dictionaryapp.utils.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val repository: WordRepository
) : ViewModel() {

   private val _state = mutableStateOf(WordState())
   val state: State<WordState> get() = _state

   fun getWord(lang: String, word: String) {
      repository.getWord(lang, word).onEach { wordList ->
         when (wordList) {
            is ResponseState.Loading -> {
               _state.value = WordState(isLoading = true)
            }
            is ResponseState.Success -> {
               _state.value = WordState(words = wordList.data)
            }
            is ResponseState.Fail -> {
               _state.value = WordState(error = wordList.message)
            }
         }
      }.launchIn(viewModelScope)
   }

   fun saveToHistory(wordModel: WordModel) {
      viewModelScope.launch {
         val wordEntity = wordModel.toWordEntity()
         repository.insetWord(wordEntity)
      }
   }

   fun saveWordListToHistory(wordList: List<WordModel>) {
      viewModelScope.launch {
         val list = wordList.map { it.toWordEntity() }
         repository.insertWordList(list)
      }
   }

   fun deleteWord(word: String) {
      viewModelScope.launch {
         repository.deleteWord(word)
      }
   }
}