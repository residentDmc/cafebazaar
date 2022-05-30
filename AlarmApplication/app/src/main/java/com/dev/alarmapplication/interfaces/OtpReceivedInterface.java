package com.dev.alarmapplication.interfaces;

public interface OtpReceivedInterface {
  void onOtpReceived(String otp);
  void onOtpTimeout();
}