package com.dev.alarmapplication.utils.extention

import android.widget.EditText


fun isSumEditText(vararg editText: EditText):String {
    var result=""
    editText.forEach {
        result+=it.text.toString()
    }
    return result
}


fun arrayString(inputs: String): Array<String> {
    return Array(inputs.length) { inputs[it].toString() }
}