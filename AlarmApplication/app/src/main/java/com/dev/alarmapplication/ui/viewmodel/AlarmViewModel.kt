package com.dev.alarmapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import com.dev.alarmapplication.data.repository.AlarmRepository
import com.dev.alarmapplication.utils.abstracts.BaseViewModel
import com.dev.alarmapplication.utils.alarm.AlarmData

class AlarmViewModel(
    private val alarmRepository: AlarmRepository,
) : BaseViewModel() {


    fun alarmResponseLiveData(): LiveData<List<AlarmData>?> {
        alarmRepository.alarmRepository()
        return alarmRepository.getAlarmArticles()
    }

    fun currentAlarmResponseLiveData(): LiveData<List<AlarmData>> {
        alarmRepository.alarmRepository()
        return alarmRepository.getAlarmDataArticles()
    }

    fun addAlarmResponseLiveData(
        progress: Int,
        year: Int,
        month: Int,
        numberPickerHours: Int,
        numberPickerMinutes: Int
    ) {
        alarmRepository.alarmRepository()
        alarmRepository.addAlarmArticles(
            progress,
            year,
            month,
            numberPickerHours,
            numberPickerMinutes
        )
    }

    fun updateAlarmResponseLiveData(
        oldYear: Int,
        oldMonth: Int,
        oldNumberPickerHours: Int,
        oldNumberPickerMinutes: Int,
        progress: Int,
        year: Int, month: Int,
        numberPickerHours: Int,
        numberPickerMinutes: Int
    ) {
        alarmRepository.alarmRepository()
        alarmRepository.updateAlarmArticles(
            oldYear, oldMonth,
            oldNumberPickerHours,
            oldNumberPickerMinutes,
            progress,
            year, month,
            numberPickerHours,
            numberPickerMinutes
        )
    }

    fun deleteAlarmResponseLiveData(alarm: AlarmData?) {
        alarmRepository.alarmRepository()
        alarmRepository.deleteAlarmArticles(alarm)
    }

    fun getAlarmList(): List<AlarmData> {
        return alarmRepository.getAlarmList()
    }
}