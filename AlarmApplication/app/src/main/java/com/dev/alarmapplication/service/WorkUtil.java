package com.dev.alarmapplication.service;

import androidx.work.Constraints;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class WorkUtil {

    private static WorkManager mWorkManager;

    public static WorkUtil workUtil;

    private WorkUtil() {
        mWorkManager = WorkManager.getInstance();
    }

    public static WorkUtil getInstance() {
        if (workUtil == null) workUtil = new WorkUtil();
        return workUtil;
    }

    public static void startSyncing(Class workerClass,String tag) {
        Constraints constraints = new Constraints.Builder().build();
        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest.Builder(workerClass)
                .setConstraints(constraints)
                .build();
        mWorkManager.enqueue(oneTimeWorkRequest);
    }

    public static void cancelAllWork() {
        mWorkManager.cancelAllWork();
    }

}