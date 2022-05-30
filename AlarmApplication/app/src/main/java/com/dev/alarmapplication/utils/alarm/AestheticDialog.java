package com.dev.alarmapplication.utils.alarm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialog;

import com.afollestad.aesthetic.Aesthetic;

public abstract class AestheticDialog extends AppCompatDialog {

    public AestheticDialog(Context context) {
        super(context);
    }

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Aesthetic.Companion.get()
                .colorPrimary()
                .take(1)
                .subscribe(integer -> findViewById(android.R.id.content).setBackgroundColor(integer));
    }
}
