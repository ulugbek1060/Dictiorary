package com.android.dictionaryapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.dictionaryapp.ui.MainViewModel
import com.android.dictionaryapp.ui.Screen
import com.android.dictionaryapp.ui.components.StyledTextField
import com.android.dictionaryapp.ui.components.Title
import com.android.dictionaryapp.ui.components.WordItem
import com.android.dictionaryapp.ui.theme.Purple500
import com.android.dictionaryapp.ui.theme.White

@Composable
fun SearchScreen(
   navController: NavController,
   viewModel: MainViewModel = hiltViewModel()
) {
   val state = viewModel.state.value
   val modifier = Modifier
   Box(modifier = modifier.fillMaxSize()) {
      Column(modifier = modifier.fillMaxSize()) {
         Column(
            modifier = modifier
               .fillMaxWidth()
               .background(color = Purple500),
         ) {
            Title(
               text = "Dictionary",
               textColor = White
            )

            StyledTextField(
               modifier = modifier
                  .padding(
                     start = 20.dp,
                     end = 20.dp,
                     bottom = 20.dp
                  ),
               "Enter text...",
               onValueChange = { query ->
                  viewModel.getWord("en", query)
               },
               color = Color.White
            )
         }
         LazyColumn(modifier = modifier.fillMaxSize()) {
            items(state.words) { word ->
               WordItem(
                  wordModel = word,
                  onItemClick = {
                     navController.navigate(Screen.DetailScreen.route + "/${word.word}")
                     viewModel.saveToHistory(word)
                  }
               )
            }
         }
      }
      if (state.error.isNotBlank()) {
         Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = modifier
               .fillMaxWidth()
               .padding(horizontal = 20.dp)
               .align(Alignment.Center)
         )
      }
      if (state.isLoading) {
         CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
      }
   }
}

