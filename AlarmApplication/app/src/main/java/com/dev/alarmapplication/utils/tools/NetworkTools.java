package com.dev.alarmapplication.utils.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dev.alarmapplication.utils.application.AppOfficialOrinab;

import java.util.Objects;

public class NetworkTools {

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) AppOfficialOrinab.activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();
        return activeNetworkInfo == null;
    }
}