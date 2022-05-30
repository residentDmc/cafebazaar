package com.dev.alarmapplication.utils.extention

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import com.google.android.material.internal.CheckableImageButton

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import com.dev.alarmapplication.R
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.START_PHONE_NUMBER_VALIDATION


fun findTogglePasswordButton(viewGroup: ViewGroup): View? {
    val childCount = viewGroup.childCount
    for (ind in 0 until childCount) {
        val child: View = viewGroup.getChildAt(ind)
        if (child is ViewGroup) {
            val togglePasswordButton: View? = findTogglePasswordButton(child)
            if (togglePasswordButton != null) {
                return togglePasswordButton
            }
        } else if (child is CheckableImageButton) {
            return child
        }
    }
    return null
}

fun activeTextInputLayout(context:Context,textInputLayout: TextInputLayout) {
    textInputLayout.error = null
    textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
    textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
    textInputLayout.boxStrokeWidth = 5
    textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
    textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)
}

fun initResultTypeAdOnTextChanged(
    context: Context,
    textInputLayout: TextInputLayout,
    text: CharSequence?
) {
    if (text!!.isNotEmpty())
        return when {
            (text.length > 9) -> {
                textInputLayout.error = null
                textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
                textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
                textInputLayout.boxStrokeWidth = 5
                textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)

            }
            else -> {
                textInputLayout.error = context.resources.getString(R.string.type_ad_must_be_10_digits)
            }
        }
    else {
        textInputLayout.error = " "
        textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.primary))
        textInputLayout.boxStrokeColor = context.resources.getColor(R.color.primary)
        textInputLayout.helperText = " "
        textInputLayout.boxStrokeWidth = 3
        textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_accent)!!)
        textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.primary)))
    }
}

fun initResultDescriptionOnTextChanged(
    context: Context,
    textInputLayout: TextInputLayout,
    text: CharSequence?
) {
    if (text!!.isNotEmpty())
        return when {
            (text.length > 19) -> {
                textInputLayout.error = null
                textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
                textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
                textInputLayout.boxStrokeWidth = 5
                textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)

            }
            else -> {
                textInputLayout.error = context.resources.getString(R.string.description_ad_must_be_20_digits)
            }
        }
    else {
        textInputLayout.error = " "
        textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.primary))
        textInputLayout.boxStrokeColor = context.resources.getColor(R.color.primary)
        textInputLayout.helperText = " "
        textInputLayout.boxStrokeWidth = 3
        textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_accent)!!)
        textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.primary)))
    }
}

fun initResultPhoneNumberDoOnTextChanged(
    context: Context,
    textInputLayout: TextInputLayout,
    text: CharSequence?
) {
    if (text!!.isNotEmpty())
        return when {
            (text.length > 10) -> {
                textInputLayout.error = null
                textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
                textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
                textInputLayout.boxStrokeWidth = 5
                textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)
            }
            else -> textInputLayout.error = context.resources.getString(R.string.phone_number_must_be_11_digits)
        }
    else {
        textInputLayout.error = " "
        textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.primary))
        textInputLayout.boxStrokeColor = context.resources.getColor(R.color.primary)
        textInputLayout.helperText = " "
        textInputLayout.boxStrokeWidth = 3
        textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_accent)!!)
        textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.primary)))
    }
}


fun initResultPriceOnTextChanged(
    context: Context,
    textInputLayout: TextInputLayout,
    textInputLayoutDiscountPrice: TextInputLayout,
    text: CharSequence?
) {
    if (text!!.isNotEmpty())
        return when {
            (text.length > 1) -> {
                textInputLayoutDiscountPrice.visibility=View.VISIBLE
                textInputLayout.error = null
                textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
                textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
                textInputLayout.boxStrokeWidth = 5
                textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)

            }
            else -> {
                textInputLayoutDiscountPrice.visibility=View.GONE
                textInputLayout.error = context.resources.getString(R.string.price_ad_not_empty)
            }
        }
    else {
        textInputLayoutDiscountPrice.visibility=View.GONE
        textInputLayout.error = " "
        textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.primary))
        textInputLayout.boxStrokeColor = context.resources.getColor(R.color.primary)
        textInputLayout.helperText = " "
        textInputLayout.boxStrokeWidth = 3
        textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_accent)!!)
        textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.primary)))
    }
}

fun initResultPriceOnTextChanged(
    context: Context,
    textInputLayout: TextInputLayout,
    text: CharSequence?
) {
    if (text!!.isNotEmpty())
        return when {
            (text.length > 1) -> {
                textInputLayout.error = null
                textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
                textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
                textInputLayout.boxStrokeWidth = 5
                textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)

            }
            else -> {
                textInputLayout.error = context.resources.getString(R.string.price_ad_not_empty)
            }
        }
    else {
        textInputLayout.error = " "
        textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.primary))
        textInputLayout.boxStrokeColor = context.resources.getColor(R.color.primary)
        textInputLayout.helperText = " "
        textInputLayout.boxStrokeWidth = 3
        textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_accent)!!)
        textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.primary)))
    }
}

fun initResultMobileDoOnTextChanged(
    context: Context,
    textInputLayout: TextInputLayout,
    text: CharSequence?
) {
    if (text!!.length > 1)
        return when {
            (text.substring(0, 2) == START_PHONE_NUMBER_VALIDATION) -> {
                if (text.length > 10) {
                    textInputLayout.helperText =" "
                    textInputLayout.error = null
                    textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
                    textInputLayout.boxStrokeColor = context.resources.getColor(R.color.color_green)
                    textInputLayout.boxStrokeWidth = 5
                    textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                    textInputLayout.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)
                } else {
                    textInputLayout.error = context.resources.getString(R.string.mobile_number_must_be_11_digits)
                }
            }
            else -> textInputLayout.error = context.resources.getString(R.string.not_validate_mobile)
        }
    else {
        textInputLayout.error = " "
        textInputLayout.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.primary))
        textInputLayout.boxStrokeColor = context.resources.getColor(R.color.primary)
        textInputLayout.helperText = context.resources.getString(R.string.description_mobile_number)
        textInputLayout.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.primary)))
    }
}

fun initResultDiscountPriceOnTextChanged(
    context: Context,
    textInputLayoutDiscountPrice: TextInputLayout,
    text: CharSequence?
) {

    if (text!!.isNotEmpty())
        return when {
            (text.length > 1) -> {
                textInputLayoutDiscountPrice.error = null
                textInputLayoutDiscountPrice.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.color_green)))
                textInputLayoutDiscountPrice.boxStrokeColor = context.resources.getColor(R.color.color_green)
                textInputLayoutDiscountPrice.boxStrokeWidth = 5
                textInputLayoutDiscountPrice.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.color_green))
                textInputLayoutDiscountPrice.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_green)!!)
            }
            else -> {
                textInputLayoutDiscountPrice.error = context.resources.getString(R.string.discount_price_ad_not_empty)
            }
        }
    else {
        textInputLayoutDiscountPrice.error = " "
        textInputLayoutDiscountPrice.hintTextColor = ColorStateList.valueOf(context.resources.getColor(R.color.primary))
        textInputLayoutDiscountPrice.boxStrokeColor = context.resources.getColor(R.color.primary)
        textInputLayoutDiscountPrice.helperText = " "
        textInputLayoutDiscountPrice.boxStrokeWidth = 3
        textInputLayoutDiscountPrice.setBoxStrokeColorStateList(ContextCompat.getColorStateList(context,R.color.selector_accent)!!)
        textInputLayoutDiscountPrice.setHelperTextColor(ColorStateList.valueOf(context.resources.getColor(R.color.primary)))
    }
}