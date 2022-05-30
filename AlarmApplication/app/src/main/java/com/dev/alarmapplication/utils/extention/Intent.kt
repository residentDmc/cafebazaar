package com.dev.alarmapplication.utils.extention

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat.startActivity
import com.dev.alarmapplication.R
import saschpe.android.customtabs.CustomTabsHelper.Companion.addKeepAliveExtra
import saschpe.android.customtabs.CustomTabsHelper.Companion.openCustomTab
import saschpe.android.customtabs.WebViewFallback


fun intentChromeUrl(context: Context, url:String){
    val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_close)
    val customTabsIntent: CustomTabsIntent = CustomTabsIntent.Builder()
        .addDefaultShareMenuItem()
        .setToolbarColor(context.resources.getColor(R.color.primary_dark))
        .setShowTitle(true)
        .setCloseButtonIcon(bitmap)
        .build()
    addKeepAliveExtra(context, customTabsIntent.intent)
    openCustomTab(
        context, customTabsIntent,
        Uri.parse(url),
        WebViewFallback()
    )
}


fun intentChrome(context: Context, url:String){
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(browserIntent)
}

fun initResetApp(activity: Activity){
    val intent = Intent()
    intent.setClass(activity, activity.javaClass)
    activity.startActivity(intent)
    activity.finish()
}