package com.dev.alarmapplication.service

import android.app.AlarmManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.dev.alarmapplication.ui.view.activity.AlarmActivity
import com.dev.alarmapplication.utils.alarm.AlarmData
import com.dev.alarmapplication.utils.alarm.Alarmio
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.BUNDLE_ALARM_HOURS
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.EXTRA_ALARM_ID

class AlarmReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {
        Log.d("sajadddddddddddd", "AlarmReceiver: ")
        val manager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmio: Alarmio = context.applicationContext as Alarmio
        val index = intent.getIntExtra(
            EXTRA_ALARM_ID,
            0
        )
        val size: Int = alarmio.alarms.size
        if (index < size) {
            val alarm: AlarmData = alarmio.alarms[intent.getIntExtra(
                EXTRA_ALARM_ID,
                0
            )]
            if (alarm.isRepeat) alarm.set(context, manager) else alarm.setEnabled(
                alarmio,
                manager,
                false
            )
            alarmio.onAlarmsChanged()
            val ringer = Intent(context, AlarmActivity::class.java)
            ringer.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            ringer.putExtra(BUNDLE_ALARM_HOURS, BUNDLE_ALARM_HOURS)
            context.startActivity(ringer)
        }
    }
}