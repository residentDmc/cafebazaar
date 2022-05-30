package com.dev.alarmapplication.data.repository

import android.app.AlarmManager
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev.alarmapplication.utils.alarm.AlarmData
import com.dev.alarmapplication.utils.alarm.Alarmio
import java.util.*
import kotlin.collections.ArrayList

class AlarmRepository{

    private var alarmList: List<AlarmData>? = null
    private var alarmio: Alarmio? = null

    fun alarmRepository() {
        if (alarmio==null){
            alarmio = Alarmio.context.applicationContext as Alarmio
            alarmList = alarmio!!.alarms
        }
    }


    fun getAlarmArticles(): LiveData<List<AlarmData>?> {
        val data: MutableLiveData<List<AlarmData>?> = MutableLiveData<List<AlarmData>?>()
        data.value = alarmList
        return data
    }

    fun getAlarmDataArticles(): LiveData<List<AlarmData>> {
        val data: MutableLiveData<List<AlarmData>> = MutableLiveData<List<AlarmData>>()
        val date = Date(System.currentTimeMillis())
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.time = date
        val alarmDataResult: List<AlarmData> =
            getAlarmDataResult(calendar.time.hours, calendar.time.minutes)
        data.value = alarmDataResult
        return data
    }

    fun addAlarmArticles(
        progress: Int,
        year: Int,
        month: Int,
        numberPickerHours: Int,
        numberPickerMinutes: Int
    ) {
        val manager = Alarmio.context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmData: AlarmData = alarmio!!.newAlarm()
        alarmData.time.set(Calendar.HOUR_OF_DAY, numberPickerHours)
        alarmData.time.set(Calendar.MINUTE, numberPickerMinutes)
        alarmData.time.set(Calendar.MONTH, month)
        alarmData.time.set(Calendar.YEAR, year)
        alarmData.setTime(alarmio, manager, alarmData.time.timeInMillis)
        alarmData.setProgress(alarmio, progress)
        alarmData.setEnabled(alarmio, manager, true)
        alarmio!!.onAlarmsChanged()
    }

    fun updateAlarmArticles(
        oldYear: Int,
        oldMonth: Int,
        oldNumberPickerHours: Int,
        oldNumberPickerMinutes: Int,
        progress: Int, year: Int, month: Int, numberPickerHours: Int, numberPickerMinutes: Int
    ) {
        getAlarmData(oldYear, oldMonth, oldNumberPickerHours, oldNumberPickerMinutes)
        val alarmData: AlarmData = alarmio!!.newAlarm()
        val manager = Alarmio.context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmData.time.set(Calendar.YEAR, year)
        alarmData.time.set(Calendar.MONTH, month)
        alarmData.time.set(Calendar.HOUR_OF_DAY, numberPickerHours)
        alarmData.time.set(Calendar.MINUTE, numberPickerMinutes)
        alarmData.setTime(alarmio, manager, alarmData.time.timeInMillis)
        alarmData.setProgress(alarmio, progress)
        alarmData.setEnabled(alarmio, manager, true)
        alarmio!!.onAlarmsChanged()
    }

    private fun getAlarmData(oldYear: Int, oldMonth: Int, oldNumberPickerHours: Int, oldNumberPickerMinutes: Int) {
        for (i in 0 until alarmio!!.alarms.size) {
            val currentDate = Date(alarmio!!.alarms[i].time.time.time)
            val currentCal=resultCalendar(currentDate)
            val year: Int = currentCal[Calendar.YEAR]
            val month: Int = currentCal[Calendar.MONTH]
            val hours: Int = currentCal[Calendar.HOUR_OF_DAY]
            val minutes: Int = currentCal[Calendar.MINUTE]
            if (year == oldYear && month == oldMonth && hours == oldNumberPickerHours && minutes == oldNumberPickerMinutes) {
                val alarmData: AlarmData = alarmio!!.alarms[i]
                alarmio!!.removeAlarm(alarmData)
                break
            }
        }
    }

    private fun resultCalendar(oldDate: Date): Calendar {
        val cal = Calendar.getInstance()
        cal.time=oldDate
        return cal
    }

    private fun getAlarmDataResult(
        oldNumberPickerHours: Int,
        oldNumberPickerMinutes: Int
    ): List<AlarmData> {
        val alarmDataList: MutableList<AlarmData> = ArrayList<AlarmData>()
        for (i in 0 until alarmio!!.alarms.size) {
            val hours: Int = alarmio!!.alarms[i].time.time.hours
            val minutes: Int = alarmio!!.alarms[i].time.time.minutes
            if (hours == oldNumberPickerHours && minutes == oldNumberPickerMinutes) {
                val alarmData: AlarmData = alarmio!!.alarms[i]
                alarmDataList.add(alarmData)
                break
            }
        }
        return alarmDataList
    }

    fun deleteAlarmArticles(alarm: AlarmData?) {
        alarmio!!.removeAlarm(alarm)
    }

    fun getAlarmList(): List<AlarmData> {
        return if (alarmio==null) ArrayList() else
            alarmio!!.alarmList
    }


}