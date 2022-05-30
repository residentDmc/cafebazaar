package com.dev.alarmapplication.utils.extention

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import com.dev.alarmapplication.R
import com.dev.alarmapplication.data.model.response.my_ads_shaypoor.ModerationStatus
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.PATTERN_DATE_TIMEZONE
import saman.zamani.persiandate.PersianDate
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDate(textView: TextView, createdAt: String, type: String) {
    val format = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    val date = format.parse(createdAt)
    val persianDate = PersianDate(date)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}"
    textView.text = "$type $resultFormatDate"
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateMontDay(date: Date): String {
    val persianDate = PersianDate(date)
    return "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${
        intCheckDay(
            persianDate.shDay
        )
    }"
}

fun intCheckMonth(shMonth: Int): String = when {
    shMonth + 1 < 10 -> "0" + (shMonth + 1)
    else -> (shMonth + 1).toString()
}

fun intCheckMonthNotMin(shMonth: Int): String = when {
    shMonth + 1 < 10 -> "0$shMonth"
    else -> (shMonth + 1).toString()
}

fun intCheckDay(shDay: Int): String = when {
    shDay + 1 < 10 -> "0$shDay"
    else -> shDay.toString()
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtTime(textView: TextView, createdAt: String, type: String) {
    val format = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    val date = format.parse(createdAt)
    val persianDate = PersianDate(date)
    val resultFormatDate = "${intCheckHour(persianDate.hour)}:${intCheckMinute(persianDate.minute)}"
    textView.text = "$type $resultFormatDate"
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateAndTime(textView: TextView, createdAt: String) {
    val format = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    val date = format.parse(createdAt)
    val persianDate = PersianDate(date)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}  ${
            intCheckHour(persianDate.hour)
        }:${intCheckMinute(persianDate.minute)}"
    textView.text = resultFormatDate
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateAndTimeLong(textView: TextView, milliSeconds: Long) {
    val persianDate = PersianDate(milliSeconds)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}  ${
            intCheckHour(persianDate.hour)
        }:${intCheckMinute(persianDate.minute)}"
    textView.text = resultFormatDate
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateLong(textView: TextView, milliSeconds: Long) {
    val persianDate = PersianDate(milliSeconds)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}"
    textView.text = resultFormatDate
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtTimeLong(textView: TextView, milliSeconds: Long) {
    val persianDate = PersianDate(milliSeconds)
    val resultFormatDate = "${
        intCheckHour(persianDate.hour)
    }:${intCheckMinute(persianDate.minute)}"
    textView.text = resultFormatDate
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initResultCreatedAtDateLong(milliSeconds: Long): String {
    val persianDate = PersianDate(milliSeconds)
    return "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${
        intCheckDay(
            persianDate.shDay
        )
    }"
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initResultCreatedAtTimeLong(milliSeconds: Long): String {
    val persianDate = PersianDate(milliSeconds)
    return "${
        intCheckHour(persianDate.hour)
    }:${intCheckMinute(persianDate.minute)}"
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateAndTime(textInputLayout: TextInputLayout, createdAt: String) {
    val format = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    val date = format.parse(createdAt)
    val persianDate = PersianDate(date)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}  ${
            intCheckHour(persianDate.hour)
        }:${intCheckMinute(persianDate.minute)}"
    textInputLayout.editText!!.setText(resultFormatDate)
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDate(textInputLayout: TextInputLayout, createdAt: String) {
    val format = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    val date = format.parse(createdAt)
    val persianDate = PersianDate(date)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}"
    textInputLayout.editText!!.setText(resultFormatDate)
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateAndTimeNotMin(textInputLayout: TextInputLayout, createdAt: String) {
    val format = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    val date = format.parse(createdAt)
    val persianDate = PersianDate(date)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}  ${
            intCheckHour(persianDate.hour)
        }:${intCheckMinute(persianDate.minute)}"
    textInputLayout.editText!!.setText(resultFormatDate)
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateAndTimeNotMinLong(textInputLayout: TextInputLayout, milliSeconds: Long) {
    val persianDate = PersianDate(milliSeconds)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}  ${
            intCheckHour(persianDate.hour)
        }:${intCheckMinute(persianDate.minute)}"
    textInputLayout.editText!!.setText(resultFormatDate)
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtDateAndTimeNotMin(textView: TextView, createdAt: String) {
    val format = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    val date = format.parse(createdAt)
    val persianDate = PersianDate(date)
    val resultFormatDate =
        "${persianDate.shYear}-${intCheckMonthNotMin(persianDate.shMonth)}-${intCheckDay(persianDate.shDay)}  ${
            intCheckHour(persianDate.hour)
        }:${intCheckMinute(persianDate.minute)}"
    textView.text = resultFormatDate
}

@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun getDate(milliSeconds: Long): String {
    val c = Calendar.getInstance()
    c.timeInMillis = milliSeconds
    val d = c.time
    val sdf = SimpleDateFormat(PATTERN_DATE_TIMEZONE)
    return sdf.format(d)
}


@SuppressLint("SimpleDateFormat", "SetTextI18n")
fun initCreatedAtTime(date: Date): String {
    val persianDate = PersianDate(date)
    return "${intCheckHour(persianDate.hour)}:${intCheckMinute(persianDate.minute)}"
}

fun intCheckHour(hour: Int): String = when {
    hour + 1 < 10 -> "0$hour"
    else -> hour.toString()
}

fun intCheckMinute(minute: Int): String = when {
    minute + 1 < 10 -> "0$minute"
    else -> minute.toString()
}


fun checkStatusLeave(context: Context, textView: TextView, status: Int): Unit = when (status) {
    2 -> initRegistered(context, textView)
    1 -> initAwaitingApproval(context, textView)
    else -> initFailed(context, textView)
}

fun checkStatusReport(context: Context, textView: TextView, status: Int): Unit = when (status) {
    1 -> initDone(context, textView)
    else -> initNotDone(context, textView)
}

fun initDone(context: Context, textView: TextView) {
    textView.text = context.resources.getString(R.string.done)
    textView.setBackgroundResource(R.drawable.shape_final_confirmed)
}

fun initNotDone(context: Context, textView: TextView) {
    textView.text = context.resources.getString(R.string.not_done)
    textView.setBackgroundResource(R.drawable.shape_failed)
}

fun checkStatusTypeOfLeave(context: Context, textInputLayout: TextInputLayout, status: Int) {
    when (status) {
        1 -> textInputLayout.editText!!.setText(context.resources.getString(R.string.entitlement))
        2 -> textInputLayout.editText!!.setText(context.resources.getString(R.string.no_rights))
        else -> textInputLayout.editText!!.setText(context.resources.getString(R.string.sick))
    }
}

fun checkStatusTypeOfLeave(context: Context, textView: TextView, status: Int): Unit =
    when (status) {
        1 -> textView.setText(context.resources.getString(R.string.entitlement))
        2 -> textView.setText(context.resources.getString(R.string.no_rights))
        else -> textView.setText(context.resources.getString(R.string.sick))
    }

fun checkStatusTypeOfMission(
    context: Context,
    textInputLayout: TextInputLayout,
    status: Int
): Unit = when (status) {
    1 -> textInputLayout.editText!!.setText(context.resources.getString(R.string.banking_services))
    2 -> textInputLayout.editText!!.setText(context.resources.getString(R.string.collection_services))
    3 -> textInputLayout.editText!!.setText(context.resources.getString(R.string.measurements))
    else -> textInputLayout.editText!!.setText(context.resources.getString(R.string.installation))
}

fun checkStatusTypeOfMission(context: Context, textView: TextView, status: Int): Unit =
    when (status) {
        1 -> textView.setText(context.resources.getString(R.string.banking_services))
        2 -> textView.setText(context.resources.getString(R.string.collection_services))
        3 -> textView.setText(context.resources.getString(R.string.measurements))
        else -> textView.setText(context.resources.getString(R.string.installation))
    }

fun checkStatusTypeOfArrivalsAndDepartures(
    context: Context,
    materialTextViewValue: MaterialTextView,
    materialTextViewState: MaterialTextView,
    status: Int
) {
    when (status) {
        1 -> initArrival(context, materialTextViewState, materialTextViewValue)
        else -> initDepartures(context, materialTextViewState, materialTextViewValue)
    }
}

private fun setTextViewDrawableColor(textView: MaterialTextView, color: Int) {
    for (drawable in textView.compoundDrawables) {
        if (drawable != null) {
            drawable.colorFilter =
                PorterDuffColorFilter(
                    ContextCompat.getColor(textView.context, color),
                    PorterDuff.Mode.SRC_IN
                )
        }
    }
}

fun checkDescription(context: Context, textView: TextView, description: String?) {
    description.let {
        when {
            it.isNullOrEmpty() -> textView.text =
                context.resources.getString(R.string.no_description_entered)
            else -> textView.text = it
        }
    }
}


fun checkStatusLeave(
    context: Context,
    textView: TextView,
    cardView: CardView,
    moderationStatus: ModerationStatus
) {
    val color: Int = Color.parseColor(moderationStatus.color)
    val colorStateList = ColorStateList.valueOf(color)
    textView.text = moderationStatus.title
    cardView.setCardBackgroundColor(colorStateList)

}

fun checkStatus(context: Context, textView: TextView, imgBtnTime: View, status: Int): Unit =
    when (status) {
        0 -> initFinalConfirmed(context, textView, imgBtnTime)
        1 -> initInitialConfirmed(context, textView, imgBtnTime)
        2 -> initAwaitingApproval(context, textView, imgBtnTime)
        else -> initFailed(context, textView, imgBtnTime)
    }


fun initArrival(context: Context, textView: TextView, materialTextViewValue: MaterialTextView) {
    materialTextViewValue.text = context.resources.getString(R.string.start_date_arrived)
    textView.text = context.resources.getString(R.string.getting_to_work)
    textView.setBackgroundResource(R.drawable.shape_final_confirmed)
}

fun initFinalConfirmed(context: Context, textView: TextView, imgBtnTime: View) {
    textView.text = context.resources.getString(R.string.final_approval)
    textView.setBackgroundResource(R.drawable.shape_final_confirmed)
    imgBtnTime.visibility = View.VISIBLE
}

fun initRegistered(context: Context, textView: TextView) {
    textView.text = context.resources.getString(R.string.registered)
    textView.setBackgroundResource(R.drawable.shape_final_confirmed)
}

fun initRegistered(textView: TextView, status: String) {
    textView.text = status
    textView.setBackgroundResource(R.drawable.shape_final_confirmed)
}

fun initInitialConfirmed(context: Context, textView: TextView, imgBtnTime: View) {
    textView.text = context.resources.getString(R.string.initial_approval)
    textView.setBackgroundResource(R.drawable.shape_initial_approval)
    imgBtnTime.visibility = View.VISIBLE
}

fun initAwaitingApproval(context: Context, textView: TextView, imgBtnTime: View) {
    textView.text = context.resources.getString(R.string.awaiting_approval)
    textView.setBackgroundResource(R.drawable.shape_awaiting_approval)
    imgBtnTime.visibility = View.INVISIBLE
}

fun initAwaitingApproval(context: Context, textView: TextView) {
    textView.text = context.resources.getString(R.string.awaiting_approval)
    textView.setBackgroundResource(R.drawable.shape_awaiting_approval)
}

fun initAwaitingApproval(textView: TextView, status: String) {
    textView.text = status
    textView.setBackgroundResource(R.drawable.shape_awaiting_approval)
}

fun initFailed(context: Context, textView: TextView, imgBtnTime: View) {
    textView.text = context.resources.getString(R.string.failed)
    textView.setBackgroundResource(R.drawable.shape_failed)
    imgBtnTime.visibility = View.VISIBLE
}

fun initFailed(context: Context, textView: TextView) {
    textView.text = context.resources.getString(R.string.failed)
    textView.setBackgroundResource(R.drawable.shape_failed)
}

fun initFailed(textView: TextView, status: String) {
    textView.text = status
    textView.setBackgroundResource(R.drawable.shape_failed)
}


fun initDepartures(context: Context, textView: TextView, materialTextViewValue: MaterialTextView) {
    materialTextViewValue.text = context.resources.getString(R.string.start_date_departures)
    textView.text = context.resources.getString(R.string.leaving_work)
    textView.setBackgroundResource(R.drawable.shape_failed)
}
