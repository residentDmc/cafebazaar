package com.dev.alarmapplication.utils.alarm;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.LocationManager;
import android.media.Ringtone;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.multidex.MultiDex;

import com.afollestad.aesthetic.Aesthetic;
import com.afollestad.aesthetic.AutoSwitchMode;
import com.dev.alarmapplication.R;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.dto.Location;
import com.dev.alarmapplication.utils.application.AppOfficialOrinab;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class Alarmio extends AppOfficialOrinab implements Player.EventListener {
    // h

    public static final int THEME_DAY_NIGHT = 0;
    public static final int THEME_DAY = 1;
    public static final int THEME_NIGHT = 2;
    public static final int THEME_AMOLED = 3;


    public static final String CHANNEL_ID = "exampleChannel";
    public static final String NOTIFICATION_CHANNEL_STOPWATCH = "stopwatch";
    public static final String NOTIFICATION_CHANNEL_TIMERS = "timers";
    public static Context context;
    public static Activity activity;

    private SharedPreferences prefs;
    private SunriseSunsetCalculator sunsetCalculator;

    private Ringtone currentRingtone;

    private List<AlarmData> alarms;
    private List<TimerData> timers;
    private final Handler handler=new Handler();

    private List<AlarmioListener> listeners;
    private ActivityListener listener;

    private SimpleExoPlayer player;
    private HlsMediaSource.Factory hlsMediaSourceFactory;
    private String currentStream;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        try {
            MultiDex.install(this);
        } catch (RuntimeException multiDexException) {
            multiDexException.printStackTrace();
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        DebugUtils.setup(this);
        MultiDex.install(this);

        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/iransansmobile.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());

        context=getApplicationContext();
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        listeners = new ArrayList<>();
        alarms = new ArrayList<>();
        timers = new ArrayList<>();

        player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
        player.addListener(this);

        DefaultDataSourceFactory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "exoplayer2example"), null);
        hlsMediaSourceFactory = new HlsMediaSource.Factory(dataSourceFactory);

        int alarmLength = PreferenceData.ALARM_LENGTH.getValue(this);
        for (int id = 0; id < alarmLength; id++) {
            alarms.add(new AlarmData(id, this));
        }

        int timerLength = PreferenceData.TIMER_LENGTH.getValue(this);
        for (int id = 0; id < timerLength; id++) {
            TimerData timer = new TimerData(id, this);
            if (timer.isSet())
                timers.add(timer);
        }

        if (timerLength > 0)
            startService(new Intent(this, TimerService.class));

        SleepReminderService.refreshSleepTime(context);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Example Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            Objects.requireNonNull(manager).createNotificationChannel(channel);
        }
    }

    public List<AlarmData> getAlarms() {
        return alarms;
    }

    public List<TimerData> getTimers() {
        return timers;
    }

    /**
     * Create a new alarm, assigning it an unused preference id.
     *
     * @return          The newly instantiated [AlarmData](./data/AlarmData).
     */
    public AlarmData newAlarm() {
        AlarmData alarm = new AlarmData(alarms.size(), Calendar.getInstance());
        alarm.sound = SoundData.fromString(PreferenceData.DEFAULT_ALARM_RINGTONE.getValue(this, ""));
        alarms.add(alarm);
        onAlarmCountChanged();
        return alarm;
    }


    /**
     * Remove an alarm and all of its its preferences.
     *
     * @param alarm     The alarm to be removed.
     */
    public void removeAlarm(AlarmData alarm) {
        alarm.onRemoved(this);
        int index = alarms.indexOf(alarm);
        try{
            alarms.remove(index);
            for (int i = index; i < alarms.size(); i++) alarms.get(i).onIdChanged(i, this);
            onAlarmCountChanged();
            onAlarmsChanged();
        }catch (Exception e){
            e.getLocalizedMessage();
        }
    }

    public List<AlarmData> getAlarmList() {
        return alarms;
    }

    /**
     * Update preferences to show that the alarm count has been changed.
     */
    public void onAlarmCountChanged() {
        PreferenceData.ALARM_LENGTH.setValue(this, alarms.size());
    }

    /**
     * Notify the application of changes to the current alarms.
     */
    public void onAlarmsChanged() {
        for (AlarmioListener listener : listeners) {
            listener.onAlarmsChanged();
        }
    }

    /**
     * Create a new timer, assigning it an unused preference id.
     *
     * @return          The newly instantiated [TimerData](./data/TimerData).
     */
    public TimerData newTimer() {
        TimerData timer = new TimerData(timers.size());
        timers.add(timer);
        onTimerCountChanged();
        return timer;
    }

    /**
     * Remove a timer and all of its preferences.
     *
     * @param timer     The timer to be removed.
     */
    public void removeTimer(TimerData timer) {
        timer.onRemoved(this);

        int index = timers.indexOf(timer);
        timers.remove(index);
        for (int i = index; i < timers.size(); i++) {
            timers.get(i).onIdChanged(i, this);
        }

        onTimerCountChanged();
        onTimersChanged();
    }

    /**
     * Update the preferences to show that the timer count has been changed.
     */
    public void onTimerCountChanged() {
        PreferenceData.TIMER_LENGTH.setValue(this, timers.size());
    }

    /**
     * Notify the application of changes to the current timers.
     */
    public void onTimersChanged() {
        for (AlarmioListener listener : listeners) {
            listener.onTimersChanged();
        }
    }

    /**
     * Starts the timer service after a timer has been set.
     */
    public void onTimerStarted() {
        startService(new Intent(this, TimerReceiver.class));
    }

    /**
     * Get an instance of SharedPreferences.
     *
     * @return          The instance of SharedPreferences being used by the application.
     * @see [android.content.SharedPreferences Documentation](https://developer.android.com/reference/android/content/SharedPreferences)
     */
    public SharedPreferences getPrefs() {
        return prefs;
    }

    /**
     * Update the application theme.
     */
    public void updateTheme() {
        if (isNight()) {
            Aesthetic.Companion.get()
                    .isDark(true)
                    .lightStatusBarMode(AutoSwitchMode.OFF)
                    .colorPrimary(ContextCompat.getColor(this, R.color.primary))
                    .colorStatusBar(Color.TRANSPARENT)
                    .colorNavigationBar(ContextCompat.getColor(this, R.color.primary_dark))
                    .colorAccent(ContextCompat.getColor(this, R.color.accent))
                    .colorWindowBackground(ContextCompat.getColor(this, R.color.primary_dark))
                    .apply();
        } else {
            int theme = getActivityTheme();
            if (theme == THEME_DAY || theme == THEME_DAY_NIGHT) {
                Aesthetic.Companion.get()
                        .isDark(false)
                        .lightStatusBarMode(AutoSwitchMode.ON)
                        .colorPrimary(ContextCompat.getColor(this, R.color.primary))
                        .colorStatusBar(Color.TRANSPARENT)
                        .colorNavigationBar(ContextCompat.getColor(this, R.color.primary_dark))
                        .colorAccent(ContextCompat.getColor(this, R.color.accent))
                        .colorCardViewBackground(ContextCompat.getColor(this, R.color.primary_dark))
                        .colorWindowBackground(ContextCompat.getColor(this, R.color.primary_dark))
                        .apply();
            } else if (theme == THEME_AMOLED) {
                Aesthetic.Companion.get()
                        .isDark(true)
                        .lightStatusBarMode(AutoSwitchMode.OFF)
                        .colorPrimary(Color.BLACK)
                        .colorStatusBar(Color.TRANSPARENT)
                        .colorNavigationBar(Color.BLACK)
                        .colorAccent(Color.WHITE)
                        .colorCardViewBackground(Color.BLACK)
                        .colorWindowBackground(Color.BLACK)
                        .apply();
            }
        }
    }

    /**
     * Determine if the theme should be a night theme.
     *
     * @return          True if the current theme is a night theme.
     */
    public boolean isNight() {
        int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return ((time < getDayStart() || time > getDayEnd()) && getActivityTheme() == THEME_DAY_NIGHT) || getActivityTheme() == THEME_NIGHT;
    }

    /**
     * Get the theme to be used for activities and things. Despite
     * what the name implies, it does not return a theme resource,
     * but rather one of Alarmio.THEME_DAY_NIGHT, Alarmio.THEME_DAY,
     * Alarmio.THEME_NIGHT, or Alarmio.THEME_AMOLED.
     *
     * @return          The theme to be used for activites.
     */
    public int getActivityTheme() {
        return PreferenceData.THEME.getValue(this);
    }

    /**
     * Determine if the sunrise/sunset stuff should occur automatically.
     *
     * @return          True if the day/night stuff is automated.
     */
    public boolean isDayAuto() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && (boolean) PreferenceData.DAY_AUTO.getValue(this);
    }

    /**
     * @return the hour of the start of the day (24h), as specified by the user
     */
    public int getDayStart() {
        if (isDayAuto() && getSunsetCalculator() != null)
            return getSunsetCalculator().getOfficialSunriseCalendarForDate(Calendar.getInstance()).get(Calendar.HOUR_OF_DAY);
        else return PreferenceData.DAY_START.getValue(this);
    }

    /**
     * @return the hour of the end of the day (24h), as specified by the user
     */
    public int getDayEnd() {
        if (isDayAuto() && getSunsetCalculator() != null)
            return getSunsetCalculator().getOfficialSunsetCalendarForDate(Calendar.getInstance()).get(Calendar.HOUR_OF_DAY);
        else return PreferenceData.DAY_END.getValue(this);
    }

    /**
     * @return the hour of the calculated sunrise time, or null.
     */
    @Nullable
    public Integer getSunrise() {
        if (getSunsetCalculator() != null)
            return getSunsetCalculator().getOfficialSunsetCalendarForDate(Calendar.getInstance()).get(Calendar.HOUR_OF_DAY);
        else return null;
    }

    /**
     * @return the hour of the calculated sunset time, or null.
     */
    @Nullable
    public Integer getSunset() {
        if (getSunsetCalculator() != null)
            return getSunsetCalculator().getOfficialSunsetCalendarForDate(Calendar.getInstance()).get(Calendar.HOUR_OF_DAY);
        else return null;
    }

    /**
     * @return the current SunriseSunsetCalculator object, or null if it cannot
     *         be instantiated.
     * @see [SunriseSunsetLib Repo](https://github.com/mikereedell/sunrisesunsetlib-java)
     */
    @Nullable
    private SunriseSunsetCalculator getSunsetCalculator() {
        if (sunsetCalculator == null && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            try {
                LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                android.location.Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(new Criteria(), false));
                sunsetCalculator = new SunriseSunsetCalculator(new Location(location.getLatitude(), location.getLongitude()), TimeZone.getDefault().getID());
            } catch (NullPointerException ignored) {
            }
        }

        return sunsetCalculator;
    }

    /**
     * Determine if a ringtone is currently playing.
     *
     * @return          True if a ringtone is currently playing.
     */
    public boolean isRingtonePlaying() {
        return currentRingtone != null && currentRingtone.isPlaying();
    }

    /**
     * Get the currently playing ringtone.
     *
     * @return          The currently playing ringtone, or null.
     */
    @Nullable
    public Ringtone getCurrentRingtone() {
        return currentRingtone;
    }

    public void playRingtone(Ringtone ringtone) {
        if (!ringtone.isPlaying()) {
            stopCurrentSound();
            ringtone.play();
        }

        currentRingtone = ringtone;
    }

    /**
     * Play a stream ringtone.
     *
     * @param url       The URL of the stream to be passed to ExoPlayer.
     * @see [ExoPlayer Repo](https://github.com/google/ExoPlayer)
     */
    public void playStream(String url, String type) {
        stopCurrentSound();

        player.prepare(hlsMediaSourceFactory.createMediaSource(Uri.parse(url)));

        player.setPlayWhenReady(true);
        currentStream = url;
    }

    /**
     * Play a stream ringtone.
     *
     * @param url           The URL of the stream to be passed to ExoPlayer.
     * @param attributes    The attributes to play the stream with.
     * @see [ExoPlayer Repo](https://github.com/google/ExoPlayer)
     */
    public void playStream(String url, String type, AudioAttributes attributes) {
        player.stop();
        player.setAudioAttributes(attributes);
        playStream(url, type);
    }

    /**
     * Stop the currently playing stream.
     */
    public void stopStream() {
        player.stop();
        currentStream = null;
    }

    /**
     * Determine if the passed url matches the stream that is currently playing.
     *
     * @param url           The URL to match the current stream to.
     * @return              True if the URL matches that of the currently playing
     *                      stream.
     */
    public boolean isPlayingStream(String url) {
        return currentStream != null && currentStream.equals(url);
    }

    /**
     * Stop the currently playing sound, regardless of whether it is a ringtone
     * or a stream.
     */
    public void stopCurrentSound() {
        if (isRingtonePlaying())
            currentRingtone.stop();

        stopStream();
    }

    public void addListener(AlarmioListener listener) {
        listeners.add(listener);
    }

    public void removeListener(AlarmioListener listener) {
        listeners.remove(listener);
    }

    public void setListener(ActivityListener listener) {
        this.listener = listener;

        if (listener != null)
            updateTheme();
    }

    @Override
    public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
    }

    @Override
    public void onLoadingChanged(boolean isLoading) {
    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        switch (playbackState) {
            case Player.STATE_BUFFERING:
            case Player.STATE_READY:
                break;
            default:
                currentStream = null;
                break;
        }
    }

    @Override
    public void onRepeatModeChanged(int repeatMode) {
    }

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {
        currentStream = null;
        Exception exception;
        switch (error.type) {
            case ExoPlaybackException.TYPE_RENDERER:
                exception = error.getRendererException();
                break;
            case ExoPlaybackException.TYPE_SOURCE:
                exception = error.getSourceException();
                break;
            case ExoPlaybackException.TYPE_UNEXPECTED:
                exception = error.getUnexpectedException();
                break;
            default:
                return;
        }

        exception.printStackTrace();
        Toast.makeText(this, exception.getClass().getName() + ": " + exception.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPositionDiscontinuity(int reason) {
    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    @Override
    public void onSeekProcessed() {
    }

    public void requestPermissions(String... permissions) {
        if (listener != null)
            listener.requestPermissions(permissions);
    }

    public FragmentManager getFragmentManager() {
        if (listener != null)
            return listener.gettFragmentManager();
        else return null;
    }

    public interface AlarmioListener {
            void onAlarmsChanged();

        void onTimersChanged();
    }

    public interface ActivityListener {
        void requestPermissions(String... permissions);

        FragmentManager gettFragmentManager(); //help
    }

}
