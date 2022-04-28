package com.achareh.testproject.utils.manager

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.achareh.testproject.utils.application.AppTestProject


class KeyboardManager {

    fun hideKeyboard(editText: EditText) {
        val imm =AppTestProject.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0);
    }

    fun hideKeyboard() {
        val v = AppTestProject.activity.currentFocus
        val imm = AppTestProject.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (v != null)
            imm.hideSoftInputFromWindow(v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun showKeyboard() {
        val v = AppTestProject.activity.currentFocus
        val imm = AppTestProject.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (v != null)
            imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
    }

}