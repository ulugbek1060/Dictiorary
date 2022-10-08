package com.android.dictionaryapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.dictionaryapp.date.models.WordModel

@Composable
fun WordItem(
   modifier: Modifier = Modifier,
   wordModel: WordModel,
   onItemClick: (WordModel) -> Unit
) {
   Box(modifier = modifier) {
      Row(
         modifier = modifier
            .fillMaxWidth()
            .clickable { onItemClick(wordModel) }
            .padding(18.dp)
      ) {
         Spacer(
            modifier = modifier
               .height(60.dp)
               .width(12.dp)
               .clip(RoundedCornerShape(6.dp))
               .background(Color.DarkGray.copy(alpha = 0.2f))
         )
         Column(
            modifier = modifier.padding(start = 16.dp),
            verticalArrangement = Arrangement.Center
         ) {
            Text(
               text = wordModel.word ?: "",
               style = TextStyle(
                  color = Color.Black,
                  fontSize = 20.sp
               ),
               overflow = TextOverflow.Ellipsis,
            )
            Spacer(
               modifier = modifier
                  .fillMaxWidth()
                  .height(12.dp)
            )
            Text(
               text = wordModel.phonetic ?: "",
               style = TextStyle(
                  color = Color.Gray,
                  fontSize = 16.sp
               ),
               overflow = TextOverflow.Ellipsis,
            )
         }
      }
      Spacer(
         modifier = modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(Color.DarkGray.copy(alpha = 0.2f))
      )
   }
}