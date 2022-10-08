package com.android.dictionaryapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.dictionaryapp.ui.theme.Purple500

@Composable
fun StyledTextField(
   modifier: Modifier = Modifier,
   label: String,
   onValueChange: (String) -> Unit,
   color: Color = Color.Blue
) {
   var value by remember { mutableStateOf("") }
   TextField(
      value = value,
      onValueChange = {
         value = it
         onValueChange(it)
      },
      label = { Text(label) },
      trailingIcon = {
         if (value.isNotBlank()) {
            IconButton(onClick = {
               value = ""
               onValueChange("")
            }) {
               Icon(imageVector = Icons.Filled.Close, contentDescription = "Clear")
            }
         }
      },
      maxLines = 1,
      textStyle = MaterialTheme.typography.body2,
      modifier = modifier.fillMaxWidth(),
      colors = TextFieldDefaults.textFieldColors(
         unfocusedLabelColor = Purple500,
         focusedLabelColor = Purple500,
         backgroundColor = color,
         focusedIndicatorColor = Color.Transparent,
         unfocusedIndicatorColor = Color.Transparent,
         cursorColor = Color.Blue
      ),
      shape = RoundedCornerShape(10.dp)
   )
}
