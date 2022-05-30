package com.dev.alarmapplication.service

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.dev.alarmapplication.utils.alarm.Alarmio

class RestoreOnBootReceiver: BroadcastReceiver() {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context, intent: Intent?) {
        Log.d("sajadddddddddddd", "RestoreOnBootReceiver: ")
        val alarmio: Alarmio = context.applicationContext as Alarmio
        val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        for (alarm in alarmio.alarms) if (alarm.isEnabled) alarm.set(context, manager)
        for (timer in alarmio.timers)
            if (timer.remainingMillis > 0) timer.setAlarm(context, manager)
    }


}