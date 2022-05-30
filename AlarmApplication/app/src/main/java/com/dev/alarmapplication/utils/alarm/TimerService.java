package com.dev.alarmapplication.utils.alarm;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.dev.alarmapplication.R;
import com.dev.alarmapplication.ui.view.activity.AlarmActivity;

import java.util.List;

public class TimerService extends Service {

    private static final int NOTIFICATION_ID = 427;

    private final IBinder binder = new LocalBinder();

    private final Handler handler = new Handler();
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (timers.size() > 0) {
                Notification notification = getNotification();
                if (notification != null)
                    startForeground(NOTIFICATION_ID, notification);
                handler.removeCallbacks(this);
                handler.postDelayed(this, 10);
            } else stopForeground(true);
        }
    };

    private List<TimerData> timers;
    private NotificationManager notificationManager;
    private String notificationString;

    @Override
    public void onCreate() {
        super.onCreate();
        timers = ((Alarmio) getApplicationContext()).getTimers();
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.removeCallbacks(runnable);
        runnable.run();
        return super.onStartCommand(intent, flags, startId);
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    @Nullable
    private Notification getNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            notificationManager.createNotificationChannel(new NotificationChannel(Alarmio.NOTIFICATION_CHANNEL_TIMERS, "Timers", NotificationManager.IMPORTANCE_LOW));

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        StringBuilder string = new StringBuilder();
        for (TimerData timer : timers) {
            if (!timer.isSet())
                continue;

            String time = FormatUtils.formatMillis(timer.getRemainingMillis());
            time = time.substring(0, time.length() - 3);
            inboxStyle.addLine(time);
            string.append("/").append(time).append("/");
        }

        if (notificationString != null && notificationString.equals(string.toString()))
            return null;

        notificationString = string.toString();

        Intent intent = new Intent(this, AlarmActivity.class);
        if (timers.size() == 1)
            intent.putExtra(TimerReceiver.EXTRA_TIMER_ID, 0);

        return new NotificationCompat.Builder(this, Alarmio.NOTIFICATION_CHANNEL_TIMERS)
                .setSmallIcon(R.drawable.ic_timer_notification)
                .setContentTitle(getString(R.string.title_set_timer))
                .setContentText("")
                .setContentIntent(PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT))
                .setStyle(inboxStyle)
                .build();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //listener = null;
        return super.onUnbind(intent);
    }

    public class LocalBinder extends Binder {
        public TimerService getService() {
            return TimerService.this;
        }
    }
}
