package com.dev.alarmapplication.utils.extention.work_manager

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.google.common.util.concurrent.ListenableFuture


fun isWorkScheduled(context: Context, tag: String): Boolean {
    val instance = WorkManager.getInstance(context)
    val statuses: ListenableFuture<List<WorkInfo>> = instance.getWorkInfosForUniqueWork(tag)
    var workScheduled = false
    statuses.get()?.let {
        for (workStatus in it) {
            workScheduled = (
                    workStatus.state == WorkInfo.State.ENQUEUED
                            || workStatus.state == WorkInfo.State.RUNNING
                            || workStatus.state == WorkInfo.State.BLOCKED
                            || workStatus.state.isFinished // It checks SUCCEEDED, FAILED, CANCELLED already
                    )
        }
    }
    return workScheduled
}