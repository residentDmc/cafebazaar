package com.achareh.globallydynamicapplication

import android.app.Application
import android.content.Context
import com.jeppeman.globallydynamic.globalsplitcompat.GlobalSplitCompat

class MyApplication : Application(){
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        GlobalSplitCompat.install(this)
    }
}