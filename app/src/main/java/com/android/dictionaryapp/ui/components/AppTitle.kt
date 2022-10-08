package com.android.dictionaryapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Title(
   text: String = "",
   textColor: Color
) {
   Text(
      text = text,
      fontFamily = FontFamily.SansSerif,
      fontWeight = FontWeight.Bold,
      style = MaterialTheme.typography.h4,
      color = textColor,
      maxLines = 1,
      modifier = Modifier
         .fillMaxWidth()
         .padding(20.dp)
   )
}