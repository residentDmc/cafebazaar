package com.dev.alarmapplication.utils.extention

import android.annotation.SuppressLint
import android.os.Build
import android.text.Html
import android.text.method.LinkMovementMethod
import android.webkit.WebView
import android.widget.TextView

@SuppressLint("WrongConstant", "SetJavaScriptEnabled")
fun initTextHtmlAll(webView: WebView, html:String){
    webView.setInitialScale(1)
    webView.settings.loadWithOverviewMode = true
    webView.settings.useWideViewPort = true
    webView.settings.javaScriptEnabled = true
    var text: String?
    text =  "<html><head><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/fonts/iran_sans.ttf\")}body {font-family: MyFont;font-size: small;text-align: justify;}</style></head><body>"
    text += html
    text += "</body></html>"
    webView.loadDataWithBaseURL("file:///android_asset/fonts/iran_sans.ttf",
        text, "text/html", "UTF-8", null)
}

fun initTextHtml(textView: TextView, html:String){
    textView.movementMethod = LinkMovementMethod.getInstance()
    textView.text = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT)
        else -> Html.fromHtml(html)
    }
    textView.linksClickable = true}