package com.dev.alarmapplication.utils.alarm;


import static com.dev.alarmapplication.utils.build_config.BuildConfig.BUNDLE_ALARM_HOURS;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.dev.alarmapplication.ui.view.activity.AlarmActivity;


public class TimerReceiver extends BroadcastReceiver {

    public static final String EXTRA_TIMER_ID = "james.alarmio.EXTRA_TIMER_ID";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent ringer = new Intent(context, AlarmActivity.class);
        ringer.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ringer.putExtra(BUNDLE_ALARM_HOURS, BUNDLE_ALARM_HOURS);
        context.startActivity(ringer);
    }
}
