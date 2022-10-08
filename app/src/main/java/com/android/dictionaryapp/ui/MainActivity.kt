package com.android.dictionaryapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.dictionaryapp.ui.screens.SearchScreen
import com.android.dictionaryapp.ui.theme.DictionaryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         DictionaryAppTheme {
            Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colors.background
            ) {
               val navController = rememberNavController()
               NavHost(
                  navController = navController,
                  startDestination = Screen.SearchScreen.route
               ) {
                  composable(
                     route = Screen.SearchScreen.route
                  ) {
                     SearchScreen(navController = navController)
                  }
               }
            }
         }
      }
   }
}

