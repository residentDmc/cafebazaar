package com.dev.alarmapplication.ui.view.activity


import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.dev.alarmapplication.R
import com.dev.alarmapplication.data.model.response.report.Report
import com.dev.alarmapplication.databinding.ActivityAlarmBinding
import com.dev.alarmapplication.ui.viewmodel.UserViewModel
import com.dev.alarmapplication.utils.extention.*
import com.dev.alarmapplication.utils.tools.HandleErrorTools
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class AlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmBinding
    private lateinit var ringtone: Ringtone
    private lateinit var date: Date
    private val handleErrorTools: HandleErrorTools by inject()
    private val userViewModel: UserViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            initAction()
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    private fun initAction() {
        initShowLockScreen()
        initDate()
        initAlarm()
        initCheckReportlist()
        initOnClick()
    }

    private fun initShowLockScreen() {
        val win = window
        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        win.addFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    or WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON
        )
    }

    private fun initAlarm() {
        try {
            val alert: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE)
            val player = MediaPlayer()
            player.setDataSource(this, alert)
            val audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
            if (audioManager.getStreamVolume(AudioManager.STREAM_ALARM) !== 0) {
                player.setAudioStreamType(AudioManager.STREAM_ALARM)
                player.isLooping = true
                player.prepare()
                player.start()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun initCheckReportlist() {
        userViewModel.getReports().observe(this, this::initResultReports)
    }

    private fun initResultReports(it: Any) {
        if (it is List<*>) {
            val resultList: List<Report> = it as List<Report>
            initCheklist(resultList)
        }
    }

    private fun initCheklist(resultList: List<Report>) {
        resultList.forEach { initCheck(it) }
    }

    @SuppressLint("SetTextI18n")
    private fun initCheck(it: Report) {
        date = Date()
        val userDate = initResultCreatedAtDateLong(it.dateReport)
        val userTime = initResultCreatedAtTimeLong(it.dateReport)
        val resultDate = initResultCreatedAtDateLong(date.time)
        val resultTime = initResultCreatedAtTimeLong(date.time)
        if (userDate == resultDate && userTime == resultTime) {
            binding.txtTitle.text = "${resources.getString(R.string.duties_)} ${it.type}"
            binding.txtMessage.text = "${resources.getString(R.string.description_)} ${it.desc}"
            it.state = 1
            userViewModel.updateReport(it)
            removeNotificationChanel(applicationContext, it.ids)
        }
    }

    private fun initDate() {
        date = Date()
        initCreatedAtDateLong(binding.txtDate, date.time)
        initCreatedAtTimeLong(binding.txtTime, date.time)
    }


    private fun initOnClick() {
        binding.fabDismiss.setOnClickListener { initFinish() }

    }

    private fun initFinish() {
        if (::ringtone.isInitialized)
            ringtone.stop()
        finish()
    }
}