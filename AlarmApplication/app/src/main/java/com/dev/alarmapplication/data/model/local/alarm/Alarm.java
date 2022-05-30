package com.dev.alarmapplication.data.model.local.alarm;

public class Alarm {

    private int id;

    private int progress;

    private int numberPickerHours;

    private int numberPickerMinutes;

    private String time;

    private String timeAlarm;

    private boolean alarm;

    private static Alarm alarmTools = null;

    public static Alarm getInstance() {
        if (alarmTools == null)
            alarmTools = new Alarm();
        return alarmTools;
    }

    public static Alarm getInstanceNew() {
            alarmTools = new Alarm();
        return alarmTools;
    }

    public static Alarm getInstance(String time, String timeAlarm,int progress,int numberPickerHours,int numberPickerMinutes, boolean alarm) {
        if (alarmTools == null)
            alarmTools = new Alarm(time,timeAlarm,progress,numberPickerHours,numberPickerMinutes,alarm);
        return alarmTools;
    }

    public Alarm() {
    }

    public Alarm(String time, String timeAlarm, int progress, int numberPickerHours, int numberPickerMinutes, boolean alarm) {
        this.time = time;
        this.timeAlarm = timeAlarm;
        this.progress = progress;
        this.numberPickerHours = numberPickerHours;
        this.numberPickerMinutes = numberPickerMinutes;
        this.alarm = alarm;
    }

    public Alarm(int id, String time, String timeAlarm, int progress, int numberPickerHours, int numberPickerMinutes, boolean alarm) {
        this.id = id;
        this.time = time;
        this.timeAlarm = timeAlarm;
        this.progress = progress;
        this.numberPickerHours = numberPickerHours;
        this.numberPickerMinutes = numberPickerMinutes;
        this.alarm = alarm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeAlarm() {
        return timeAlarm;
    }

    public void setTimeAlarm(String timeAlarm) {
        this.timeAlarm = timeAlarm;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getNumberPickerHours() {
        return numberPickerHours;
    }

    public void setNumberPickerHours(int numberPickerHours) {
        this.numberPickerHours = numberPickerHours;
    }

    public int getNumberPickerMinutes() {
        return numberPickerMinutes;
    }

    public void setNumberPickerMinutes(int numberPickerMinutes) {
        this.numberPickerMinutes = numberPickerMinutes;
    }
}
