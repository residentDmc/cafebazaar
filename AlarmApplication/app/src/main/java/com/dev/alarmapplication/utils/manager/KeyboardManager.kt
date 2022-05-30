package com.dev.alarmapplication.utils.manager

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.dev.alarmapplication.utils.application.AppOfficialOrinab
import com.dev.alarmapplication.utils.custom_view.search_view.MaterialSearchView


class KeyboardManager {

    fun hideKeyboard(editText: EditText) {
        val imm =AppOfficialOrinab.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0)
    }

    fun hideKeyboard(materialSearchView: MaterialSearchView) {
        val imm =AppOfficialOrinab.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(materialSearchView.windowToken, 0)
    }

    fun hideKeyboard() {
        val v = AppOfficialOrinab.activity.currentFocus
        val imm = AppOfficialOrinab.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (v != null)
            imm.hideSoftInputFromWindow(v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun showKeyboard() {
        val v = AppOfficialOrinab.activity.currentFocus
        val imm = AppOfficialOrinab.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (v != null)
            imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
    }

}