package com.dev.alarmapplication.utils.extention

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.dev.alarmapplication.R
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.CHANNEL_REPORT_ID
import com.dev.alarmapplication.utils.build_config.BuildConfig.Companion.CHANNEL_REPORT_NAME


fun initCreateNotification(context: Context, ids: Long, title: String, description: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        createNotificationChanelO(context, ids, title, description)
    } else {
        createNotificationChanelLolipop(context, ids, title, description)
    }
}

private fun createNotificationChanelLolipop(
    context: Context,
    ids: Long,
    title: String,
    description: String
) {
    val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager?
    val notification = NotificationCompat.Builder(context, CHANNEL_REPORT_ID)
    notification.setContentTitle(title)
    notification.setContentText(description)
    notification.setSmallIcon(R.drawable.ic_logo)
    manager!!.notify(ids.toInt(), notification.build())
}

@RequiresApi(Build.VERSION_CODES.O)
private fun createNotificationChanelO(
    context: Context,
    ids: Long,
    title: String,
    description: String
) {
    val channel = NotificationChannel(
        CHANNEL_REPORT_ID,
        CHANNEL_REPORT_NAME,
        NotificationManager.IMPORTANCE_HIGH
    )
    val manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager?
    manager!!.createNotificationChannel(channel)
    val notification = NotificationCompat.Builder(context, CHANNEL_REPORT_ID)
    notification.setContentTitle(title)
    notification.setContentText(description)
    notification.setSmallIcon(R.drawable.ic_logo)
    manager.notify(ids.toInt(), notification.build())
    manager.notify(ids.toInt(), notification.build())
}

fun removeNotificationChanel(
    context: Context,
    ids: Long
) {
    val notificationManager =
        context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.cancel(ids.toInt())
}