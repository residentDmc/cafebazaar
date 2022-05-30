package com.dev.alarmapplication.work_manager;

import static android.os.Build.VERSION.SDK_INT;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.dev.alarmapplication.data.model.request.login.User;
import com.dev.alarmapplication.service.GPSTracker;
import com.dev.alarmapplication.utils.application.AppOfficialOrinab;

import java.util.List;
import java.util.Objects;

public class GpsTrackerSyncJob extends Worker {

    public static boolean isWork = true;

    public GpsTrackerSyncJob(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    @NonNull
    public Worker.Result doWork() {
        User user=AppOfficialOrinab.Companion.initUser();
        boolean checkUser=AppOfficialOrinab.Companion.initUser()!=null;
        if (isWork&&checkUser) {
            int ruleId= Objects.requireNonNull(user).getRoleIds();
            if ((ruleId == 1) || (ruleId == 8)) {
                initStopService();
                return Worker.Result.failure();
            } else {
                initStartService();
                return Worker.Result.success();
            }
        } else {
            initStopService();
            return Worker.Result.failure();
        }
    }

    private void initStartService() {
        if (!isMyServiceRunning(getApplicationContext(), GPSTracker.class)) {
            Intent intent = new Intent(getApplicationContext(), GPSTracker.class);
            if (SDK_INT >= Build.VERSION_CODES.O)
                ContextCompat.startForegroundService(getApplicationContext(), intent);
            else getApplicationContext().startService(intent);
        }
    }


    private void initStopService() {
        Intent intent = new Intent(getApplicationContext(), GPSTracker.class);
        getApplicationContext().stopService(intent);
    }

    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        ActivityManager activityManager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> services =
                activityManager.getRunningServices(Integer.MAX_VALUE);
        for (int i = 0; i < services.size(); i++)
            if (services.get(i).service.getClassName().equals(serviceClass.getName())) return true;
        return false;
    }
}