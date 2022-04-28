package com.achareh.testproject.utils.extention

import android.content.Context
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.achareh.testproject.R
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.START_PHONE_NUMBER_VALIDATION
import com.google.android.material.textfield.TextInputLayout


fun isValidMobileNumber(textInputLayout: TextInputLayout): Boolean {
    val strMobileNumber = textInputLayout.editText!!.text.toString()
    return if (strMobileNumber.isEmpty()) {
        false
    } else {
        if (strMobileNumber.length > 1)
            when (strMobileNumber.substring(0, 2)) {
                START_PHONE_NUMBER_VALIDATION -> {
                    strMobileNumber.length > 10
                }
                else -> false
            } else false
    }
}

fun isValidPhoneNumber(
    textInputLayout: TextInputLayout,
): Boolean {
    val strPhoneNumber = textInputLayout.editText!!.text.toString()
    return when {
        (strPhoneNumber.length > 10) -> true
        else -> false
    }
}

fun isValidMobileNumberItem(context: Context, textInputLayout: TextInputLayout): Boolean {
    val strMobileNumber = textInputLayout.editText!!.text.toString()
    if (strMobileNumber.isEmpty()) {
        textInputLayout.error = context.resources.getString(R.string.empty_phone_number)
        return false
    } else {
        if (strMobileNumber.length > 1)
            return when (strMobileNumber.substring(0, 2)) {
                START_PHONE_NUMBER_VALIDATION -> {
                    if (strMobileNumber.length > 10) {
                        textInputLayout.error = null
                        textInputLayout.setHelperTextColor(
                            ColorStateList.valueOf(
                                context.resources.getColor(
                                    R.color.color_green
                                )
                            )
                        )
                        textInputLayout.boxStrokeColor =
                            context.resources.getColor(R.color.color_green)
                        textInputLayout.boxStrokeWidth = 5
                        textInputLayout.hintTextColor =
                            ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                        textInputLayout.setBoxStrokeColorStateList(
                            ContextCompat.getColorStateList(
                                context,
                                R.color.selector_green
                            )!!
                        )
                        true
                    } else {
                        textInputLayout.error =
                            context.resources.getString(R.string.mobile_number_must_be_11_digits)
                        false
                    }
                }
                else -> {
                    textInputLayout.error =
                        context.resources.getString(R.string.not_validate_phone_number)
                    false
                }
            } else return false
    }
}

fun isValidPhoneNumberItem(
    context: Context,
    textInputLayout: TextInputLayout,
): Boolean {
    val strPhoneNumber = textInputLayout.editText!!.text.toString()
    return when {
        (strPhoneNumber.length > 10) -> {
            textInputLayout.error = null
            textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
            textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
            textInputLayout.boxStrokeWidth = 5
            textInputLayout.hintTextColor =
                ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
            textInputLayout.setBoxStrokeColorStateList(
                ContextCompat.getColorStateList(
                    context,
                    R.color.selector_green
                )!!
            )
            true
        }
        else -> {
            textInputLayout.error =
                context.resources.getString(R.string.phone_number_must_be_11_digits)
            false
        }
    }
}

fun isValidEmptyTextWatcher(textInputLayout: TextInputLayout): Boolean {
    val strTextInputLayout = textInputLayout.editText!!.text.toString()
    return strTextInputLayout.isNotEmpty()
}

fun isValidEmptyTextWatcherItem(context: Context, textInputLayout: TextInputLayout): Boolean {
    val strTextInputLayout = textInputLayout.editText!!.text.toString()
    return if (strTextInputLayout.isNotEmpty()) {
        textInputLayout.error = null
        textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
        textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
        textInputLayout.boxStrokeWidth = 5
        textInputLayout.hintTextColor =
            ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
        textInputLayout.setBoxStrokeColorStateList(
            ContextCompat.getColorStateList(
                context,
                R.color.selector_green
            )!!
        )
        true
    } else {
        textInputLayout.error = context.resources.getString(R.string.mandatory)
        false
    }
}