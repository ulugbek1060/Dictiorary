package com.android.dictionaryapp.ui

sealed class Screen(val route: String) {
   object SearchScreen : Screen("search_screen")
   object HistoryScreen : Screen("history_screen")
   object FavoriteScreen : Screen("favorite_screen")
   object DetailScreen : Screen("detail_screen")
}