package com.dev.alarmapplication.ui.view.activity

import android.os.Bundle
import android.view.View
import com.dev.alarmapplication.R
import com.dev.alarmapplication.utils.application.AppOfficialOrinab.Companion.activity
import com.dev.alarmapplication.utils.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity =this
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
    }
}