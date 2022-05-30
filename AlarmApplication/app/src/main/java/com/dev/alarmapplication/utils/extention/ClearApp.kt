package com.dev.alarmapplication.utils.extention

import android.content.Context
import java.io.File

fun deleteCache(context: Context) {
    try {
        val dir: File = context.cacheDir
        deleteDir(dir)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

private fun deleteDir(dir: File?): Boolean {
    return if (dir != null && dir.isDirectory) {
        val children: Array<String> = dir.list()!!
        for (aChildren in children) {
            val success = deleteDir(File(dir, aChildren))
            if (!success) {
                return false
            }
        }
        dir.delete()
    } else dir != null && dir.isFile && dir.delete()
}