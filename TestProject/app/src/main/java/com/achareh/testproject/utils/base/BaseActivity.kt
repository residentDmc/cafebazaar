package com.achareh.testproject.utils.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
open class BaseActivity : AppCompatActivity() {

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        supportFragmentManager.fragments.forEach { fragment ->
            fragment.childFragmentManager.fragments.forEach {
                it.onRequestPermissionsResult(
                    requestCode,
                    permissions,
                    grantResults
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        supportFragmentManager.fragments.forEach { fragment ->
            fragment.childFragmentManager.fragments.forEach {
                it.onActivityResult(
                    requestCode,
                    resultCode,
                    data
                )
            }
        }
    }

}