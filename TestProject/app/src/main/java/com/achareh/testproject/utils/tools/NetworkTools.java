package com.achareh.testproject.utils.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.achareh.testproject.utils.application.AppTestProject;

import java.util.Objects;

public class NetworkTools {

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) AppTestProject.activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = Objects.requireNonNull(connectivityManager).getActiveNetworkInfo();
        return activeNetworkInfo == null;
    }
}