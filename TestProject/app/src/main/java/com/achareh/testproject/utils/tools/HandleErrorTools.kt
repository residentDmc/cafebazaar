package com.achareh.testproject.utils.tools

import android.util.Log


class HandleErrorTools {

    fun handleError(e: Exception) {
        Log.d("TAG", "handelError Exception: $e")
    }

    fun handleError(t: Throwable) {
        Log.d("TAG", "handelError Throwable: $t")
    }
}