package com.android.dictionaryapp

import android.util.Log

object Logger {
   private val tag = "Logger"
   fun log(obj: Any?) {
      Log.e(tag, "log: $obj")
   }
}