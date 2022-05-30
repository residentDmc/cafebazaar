package com.dev.alarmapplication.utils.alarm;

import static android.app.PendingIntent.FLAG_MUTABLE;
import static com.dev.alarmapplication.utils.build_config.BuildConfig.EXTRA_ALARM_ID;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.dev.alarmapplication.R;
import com.dev.alarmapplication.service.AlarmReceiver;
import com.dev.alarmapplication.ui.view.activity.AlarmActivity;

import java.util.Calendar;
import java.util.Date;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class AlarmData extends MultiDexApplication implements Parcelable {

    private int id;
    public String name;
    public Calendar time;
    public int progress;
    public boolean isEnabled = true;
    public boolean[] days = new boolean[7];
    public boolean isVibrate = true;
    public SoundData sound;

    @SuppressLint("StaticFieldLeak")
    public static Context context;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public void onCreate() {
        super.onCreate();
        try {
            ViewPump.init(ViewPump.builder()
                    .addInterceptor(new CalligraphyInterceptor(
                            new CalligraphyConfig.Builder()
                                    .setDefaultFontPath("fonts/iransansmobile.ttf")
                                    .setFontAttrId(R.attr.fontPath)
                                    .build()))
                    .build());

            context=getApplicationContext();
            MultiDex.install(this);
        } catch (Exception e) {

        }
    }

    public AlarmData(int id, Calendar time) {
        this.id = id;
        this.time = time;
    }

    public AlarmData(int id, Context context) {
        this.id = id;
        name = PreferenceData.ALARM_NAME.getSpecificOverriddenValue(context, getName(context), id);
        time = Calendar.getInstance();
        time.setTimeInMillis((long) PreferenceData.ALARM_TIME.getSpecificValue(context, id));
        isEnabled = PreferenceData.ALARM_ENABLED.getSpecificValue(context, id);
        for (int i = 0; i < 7; i++) {
            days[i] = PreferenceData.ALARM_DAY_ENABLED.getSpecificValue(context, id, i);
        }
        isVibrate = PreferenceData.ALARM_VIBRATE.getSpecificValue(context, id);
        sound = SoundData.fromString(PreferenceData.ALARM_SOUND.getSpecificOverriddenValue(context, PreferenceData.DEFAULT_ALARM_RINGTONE.getValue(context, ""), id));
    }

    public void onIdChanged(int id, Context context) {
        PreferenceData.ALARM_NAME.setValue(context, getName(context), id);
        PreferenceData.ALARM_TIME.setValue(context, time != null ? time.getTimeInMillis() : null, id);
        PreferenceData.ALARM_ENABLED.setValue(context, isEnabled, id);
        for (int i = 0; i < 7; i++) {
            PreferenceData.ALARM_DAY_ENABLED.setValue(context, days[i], id, i);
        }
        PreferenceData.ALARM_VIBRATE.setValue(context, isVibrate, id);
        PreferenceData.ALARM_SOUND.setValue(context, sound != null ? sound.toString() : null, id);

        onRemoved(context);
        this.id = id;
        if (isEnabled)
            set(context, (AlarmManager) context.getSystemService(Context.ALARM_SERVICE));
    }

    public void onRemoved(Context context) {
        cancel(context, (AlarmManager) context.getSystemService(Context.ALARM_SERVICE));

        PreferenceData.ALARM_NAME.setValue(context, null, id);
        PreferenceData.ALARM_TIME.setValue(context, null, id);
        PreferenceData.ALARM_ENABLED.setValue(context, null, id);
        for (int i = 0; i < 7; i++) {
            PreferenceData.ALARM_DAY_ENABLED.setValue(context, null, id, i);
        }
        PreferenceData.ALARM_VIBRATE.setValue(context, null, id);
        PreferenceData.ALARM_SOUND.setValue(context, null, id);
    }

    @SuppressLint("StringFormatInvalid")
    public String getName(Context context) {
        if (name != null)
            return name;
        else return context.getString(R.string.title_alarm, id + 1);
    }

    public boolean isRepeat() {
        for (boolean day : days) {
            if (day)
                return true;
        }

        return false;
    }

    public void setName(Context context, String name) {
        this.name = name;
        PreferenceData.ALARM_NAME.setValue(context, name, id);
    }

    public void setTime(Context context, AlarmManager manager, long timeMillis) {
        time.setTimeInMillis(timeMillis);
        PreferenceData.ALARM_TIME.setValue(context, timeMillis, id);
        if (isEnabled)
            set(context, manager);
    }

    public void setProgress(Context context,int progress) {
        PreferenceData.PROGRESS.setValue(context, progress, id);

    }

    public int getProgress(Context context) {
       return PreferenceData.PROGRESS.getValue(context);
    }

    public void setEnabled(Context context, AlarmManager manager, boolean isEnabled) {
        this.isEnabled = isEnabled;
        PreferenceData.ALARM_ENABLED.setValue(context, isEnabled, id);
        if (isEnabled)
            set(context, manager);
        else cancel(context, manager);
    }

    public void setDays(Context context, boolean[] days) {
        this.days = days;

        for (int i = 0; i < 7; i++) {
            PreferenceData.ALARM_DAY_ENABLED.setValue(context, days[i], id, i);
        }
    }

    public void setVibrate(Context context, boolean isVibrate) {
        this.isVibrate = isVibrate;
        PreferenceData.ALARM_VIBRATE.setValue(context, isVibrate, id);
    }

    public boolean hasSound() {
        return sound != null;
    }

    @Nullable
    public SoundData getSound() {
        return sound;
    }


    public void setSound(Context context, @Nullable SoundData sound) {
        this.sound = sound;
        PreferenceData.ALARM_SOUND.setValue(context, sound != null ? sound.toString() : null, id);
    }

    @Nullable
    public Calendar getNext() {
        if (isEnabled) {
            Calendar now = Calendar.getInstance();
            Calendar next = Calendar.getInstance();
            next.set(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR_OF_DAY));
            next.set(Calendar.MINUTE, time.get(Calendar.MINUTE));
            next.set(Calendar.SECOND, 0);

            while (now.after(next))
                next.add(Calendar.DATE, 1);

            if (isRepeat()) {
                int nextDay = next.get(Calendar.DAY_OF_WEEK) - 1; // index on 0-6, rather than the 1-7 returned by Calendar

                for (int i = 0; i < 7 && !days[nextDay]; i++) {
                    nextDay++;
                    nextDay %= 7;
                }

                next.set(Calendar.DAY_OF_WEEK, nextDay + 1); // + 1 = back to 1-7 range

                while (now.after(next))
                    next.add(Calendar.DATE, 7);
            }

            return next;
        }

        return null;
    }

    public Date set(Context context, AlarmManager manager) {
        Calendar nextTime = getNext();
        setAlarm(context, manager, nextTime.getTimeInMillis());
        return nextTime.getTime();
    }

    private void setAlarm(Context context, AlarmManager manager, long timeMillis) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            manager.setAlarmClock(
                    new AlarmManager.AlarmClockInfo(
                            timeMillis,
                            PendingIntent.getActivity(context, 0, new Intent(context, AlarmActivity.class), FLAG_MUTABLE)
                    ),
                    getIntent(context)
            );
        } else {
            manager.setExact(AlarmManager.RTC_WAKEUP, timeMillis, getIntent(context));

            Intent intent = new Intent("android.intent.action.ALARM_CHANGED");
            intent.putExtra("alarmSet", true);
            context.sendBroadcast(intent);
        }

        manager.set(AlarmManager.RTC_WAKEUP,
                timeMillis - (long) PreferenceData.SLEEP_REMINDER_TIME.getValue(context),
                PendingIntent.getService(context, 0, new Intent(context, SleepReminderService.class), FLAG_MUTABLE));

        SleepReminderService.refreshSleepTime(context);
    }

    public void cancel(Context context, AlarmManager manager) {
        manager.cancel(getIntent(context));

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent("android.intent.action.ALARM_CHANGED");
            intent.putExtra("alarmSet", false);
            context.sendBroadcast(intent);
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private PendingIntent getIntent(Context context) {
        Intent intent = new Intent(context, AlarmReceiver.class);
        intent.putExtra(EXTRA_ALARM_ID, id);
        return PendingIntent.getBroadcast(context, id, intent, FLAG_MUTABLE);

    }

    protected AlarmData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        time = Calendar.getInstance();
        time.setTimeInMillis(in.readLong());
        isEnabled = in.readByte() != 0;
        days = in.createBooleanArray();
        isVibrate = in.readByte() != 0;
        if (in.readByte() == 1)
            sound = SoundData.fromString(in.readString());
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeLong(time.getTimeInMillis());
        parcel.writeByte((byte) (isEnabled ? 1 : 0));
        parcel.writeBooleanArray(days);
        parcel.writeByte((byte) (isVibrate ? 1 : 0));
        parcel.writeByte((byte) (sound != null ? 1 : 0));
        if (sound != null)
            parcel.writeString(sound.toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AlarmData> CREATOR = new Creator<AlarmData>() {
        @Override
        public AlarmData createFromParcel(Parcel in) {
            return new AlarmData(in);
        }

        @Override
        public AlarmData[] newArray(int size) {
            return new AlarmData[size];
        }
    };
}
