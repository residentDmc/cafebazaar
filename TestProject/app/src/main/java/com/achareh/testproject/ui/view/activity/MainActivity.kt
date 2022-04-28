package com.achareh.testproject.ui.view.activity

import android.os.Bundle
import android.view.View
import com.achareh.testproject.R
import com.achareh.testproject.utils.application.AppTestProject.Companion.activity
import com.achareh.testproject.utils.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity =this
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_LTR
    }
}