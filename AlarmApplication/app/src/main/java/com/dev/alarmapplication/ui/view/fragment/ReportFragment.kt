package com.dev.alarmapplication.ui.view.fragment

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dev.alarmapplication.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.dev.alarmapplication.data.model.local.date.DateModel
import com.dev.alarmapplication.data.model.response.report.Report
import com.dev.alarmapplication.data.room.UserDatabase
import com.dev.alarmapplication.databinding.FragmentReportBinding
import com.dev.alarmapplication.interfaces.OnClickListenerAny
import com.dev.alarmapplication.interfaces.OnClickListenerAnyAndPosition
import com.dev.alarmapplication.ui.view.adapter.report.ReportAdapter
import com.dev.alarmapplication.ui.viewmodel.AlarmViewModel
import com.dev.alarmapplication.ui.viewmodel.UserViewModel
import com.dev.alarmapplication.utils.alarm.AlarmData
import com.dev.alarmapplication.utils.application.AppOfficialOrinab
import com.dev.alarmapplication.utils.application.AppOfficialOrinab.Companion.initUser
import com.dev.alarmapplication.utils.extention.*
import com.dev.alarmapplication.utils.manager.GridLayoutCountManager
import com.dev.alarmapplication.utils.tools.HandleErrorTools
import com.dev.alarmapplication.utils.tools.ToastTools
import ir.hamsaa.persiandatepicker.view.PersianNumberPicker
import org.koin.android.ext.android.inject
import java.util.*


class ReportFragment : Fragment() {

    private lateinit var binding: FragmentReportBinding
    private lateinit var navController: NavController
    private lateinit var bottomSheetDialogAdd: BottomSheetDialog
    private lateinit var bottomSheetDialogTime: BottomSheetDialog
    private val handleErrorTools: HandleErrorTools by inject()
    private val gridLayoutCountManager: GridLayoutCountManager by inject()
    private val toastTools: ToastTools by inject()
    private val reportAdapter: ReportAdapter by inject()
    private val userViewModel: UserViewModel by viewModel()
    private val alarmViewModel: AlarmViewModel by viewModel()
    private var report = Report()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReportBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        try {
            initAction()
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    private fun initAction() {
        initNavController()
        initToolbar()
        initOnClick()
        initAdapter()
        initOnBackPress()
    }

    private fun initListReport(listReport: List<Report>) {
        reportAdapter.updateList(listReport)
        initCheckShowList(
            binding.rcReport,
            binding.lnDataNotFound.lnParent,
            listReport.isEmpty()
        )
    }

    private fun initOnClick() {
        binding.fabAdd.setOnClickListener { initAdd() }
    }

    private fun initAdd() {
        report.userId = initUser()!!.id
        report.date = Date().time
        bottomSheetDialogAdd =
            BottomSheetDialog(AppOfficialOrinab.activity, R.style.BottomSheetDialogTheme)
        @SuppressLint("InflateParams") val viewSheet: View =
            layoutInflater.inflate(R.layout.bottom_sheet_report, null)
        bottomSheetDialogAdd.setContentView(viewSheet)
        bottomSheetDialogAdd.setCanceledOnTouchOutside(false)
        bottomSheetDialogAdd.setCancelable(false)
        bottomSheetDialogAdd.show()
        bottomSheetDialogAdd.setOnDismissListener {}
        val tlTypeOfReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlTypeOfReport)!!
        val tlStartDateReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateReport)!!
        val tlStartDateRegister =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateRegister)!!
        val tlDescription = bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlDescription)!!
        val btnVacationRegistration =
            bottomSheetDialogAdd.findViewById<MaterialButton>(R.id.btnVacationRegistration)!!
        tlTypeOfReport.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                report.type = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        tlDescription.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                report.desc = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        initCreatedAtDateAndTimeNotMinLong(tlStartDateRegister, report.date)
        tlStartDateReport.editText!!.setOnClickListener { initStartDateReportSave() }
        btnVacationRegistration.setOnClickListener { initSaveReport() }
        bottomSheetDialogAdd.setOnKeyListener(this::onKeyBottomSheetDialogAdd)
    }

    private fun initStartDateReportSave() {
        bottomSheetDialogAdd.dismiss()
        initFromPersonDatePicker(requireContext(), object : OnClickListenerAny {
            override fun onClickListener(any: Any) {
                val dateModel = any as DateModel
                initTimePickerSave(dateModel)
            }
        })
    }

    private fun initStartDateReportEdit() {
        bottomSheetDialogAdd.dismiss()
        initFromPersonDatePicker(requireContext(), object : OnClickListenerAny {
            override fun onClickListener(any: Any) {
                val dateModel = any as DateModel
                initTimePickerEdit(dateModel)
            }
        })
    }

    private fun initTimePickerEdit(dateModel: DateModel) {
        bottomSheetDialogTime =
            BottomSheetDialog(AppOfficialOrinab.activity, R.style.BottomSheetDialogTheme)
        @SuppressLint("InflateParams") val viewSheet: View =
            layoutInflater.inflate(R.layout.bottom_sheet_time, null)
        bottomSheetDialogTime.setContentView(viewSheet)
        bottomSheetDialogTime.setCanceledOnTouchOutside(false)
        bottomSheetDialogTime.setCancelable(false)
        bottomSheetDialogTime.show()
        bottomSheetDialogTime.setOnDismissListener {}
        val prnHour = bottomSheetDialogTime.findViewById<PersianNumberPicker>(R.id.prnHour)!!
        val prnMin = bottomSheetDialogTime.findViewById<PersianNumberPicker>(R.id.prnMin)!!
        val positiveButton =
            bottomSheetDialogTime.findViewById<AppCompatButton>(R.id.positive_button)!!
        val negativeButton =
            bottomSheetDialogTime.findViewById<AppCompatButton>(R.id.negative_button)!!


        initActionTimePickerEdit(prnHour, prnMin, positiveButton, negativeButton, dateModel)
        bottomSheetDialogTime.setOnKeyListener(this::onKeyBottomSheetDialogTime)
    }

    private fun initTimePickerSave(dateModel: DateModel) {
        bottomSheetDialogTime =
            BottomSheetDialog(AppOfficialOrinab.activity, R.style.BottomSheetDialogTheme)
        @SuppressLint("InflateParams") val viewSheet: View =
            layoutInflater.inflate(R.layout.bottom_sheet_time, null)
        bottomSheetDialogTime.setContentView(viewSheet)
        bottomSheetDialogTime.setCanceledOnTouchOutside(false)
        bottomSheetDialogTime.setCancelable(false)
        bottomSheetDialogTime.show()
        bottomSheetDialogTime.setOnDismissListener {}
        val prnHour = bottomSheetDialogTime.findViewById<PersianNumberPicker>(R.id.prnHour)!!
        val prnMin = bottomSheetDialogTime.findViewById<PersianNumberPicker>(R.id.prnMin)!!
        val positiveButton =
            bottomSheetDialogTime.findViewById<AppCompatButton>(R.id.positive_button)!!
        val negativeButton =
            bottomSheetDialogTime.findViewById<AppCompatButton>(R.id.negative_button)!!
        initActionTimePickerSave(prnHour, prnMin, positiveButton, negativeButton, dateModel)
        bottomSheetDialogTime.setOnKeyListener(this::onKeyBottomSheetDialogTime)
    }

    private fun initActionTimePickerSave(
        prnHour: PersianNumberPicker,
        prnMin: PersianNumberPicker,
        positiveButton: AppCompatButton,
        negativeButton: AppCompatButton,
        dateModel: DateModel
    ) {
        initPrnHour(prnHour)
        initPrnMin(prnMin)
        positiveButton.setOnClickListener { initPositiveButtonSave(prnHour, prnMin, dateModel) }
        negativeButton.setOnClickListener { bottomSheetDialogTime.dismiss() }
    }

    private fun initActionTimePickerEdit(
        prnHour: PersianNumberPicker,
        prnMin: PersianNumberPicker,
        positiveButton: AppCompatButton,
        negativeButton: AppCompatButton,
        dateModel: DateModel
    ) {
        initPrnHour(prnHour)
        initPrnMin(prnMin)
        positiveButton.setOnClickListener { initPositiveButtonEdit(prnHour, prnMin, dateModel) }
        negativeButton.setOnClickListener { bottomSheetDialogTime.dismiss() }
    }

    private fun initPrnHour(prnHour: PersianNumberPicker) {
        val typeface = ResourcesCompat.getFont(requireContext(), R.font.iran_sans)
        prnHour.setTypeFace(typeface)
        prnHour.minValue = 0
        prnHour.maxValue = 23
        prnHour.value = Date().hours
    }

    private fun initPrnMin(prnMin: PersianNumberPicker) {
        val typeface = ResourcesCompat.getFont(requireContext(), R.font.iran_sans)
        prnMin.setTypeFace(typeface)
        prnMin.minValue = 0
        prnMin.maxValue = 59
        prnMin.value = Date().minutes
    }

    private fun initPositiveButtonSave(
        prnHour: PersianNumberPicker,
        prnMin: PersianNumberPicker,
        dateModel: DateModel
    ) {
        bottomSheetDialogTime.dismiss()
        val calendar = Calendar.getInstance()
        calendar.time = dateModel.result_time_date.gregorianDate
        calendar[Calendar.HOUR_OF_DAY] = prnHour.value
        calendar[Calendar.MINUTE] = prnMin.value
        val date = calendar.time
        report.dateReport = date.time
        bottomSheetDialogAdd =
            BottomSheetDialog(AppOfficialOrinab.activity, R.style.BottomSheetDialogTheme)
        @SuppressLint("InflateParams") val viewSheet: View =
            layoutInflater.inflate(R.layout.bottom_sheet_report, null)
        bottomSheetDialogAdd.setContentView(viewSheet)
        bottomSheetDialogAdd.setCanceledOnTouchOutside(false)
        bottomSheetDialogAdd.setCancelable(false)
        bottomSheetDialogAdd.show()
        bottomSheetDialogAdd.setOnDismissListener {}
        val tlTypeOfReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlTypeOfReport)!!
        val tlStartDateReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateReport)!!
        val tlStartDateRegister =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateRegister)!!
        val tlDescription = bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlDescription)!!
        val btnVacationRegistration =
            bottomSheetDialogAdd.findViewById<MaterialButton>(R.id.btnVacationRegistration)!!
        tlTypeOfReport.editText!!.setText(report.type)
        tlDescription.editText!!.setText(report.desc)
        tlTypeOfReport.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                report.type = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        tlDescription.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                report.desc = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        initCreatedAtDateAndTimeNotMinLong(tlStartDateRegister, report.date)
        initCreatedAtDateAndTimeNotMinLong(tlStartDateReport, report.dateReport)
        btnVacationRegistration.setOnClickListener { initSaveReport() }
        tlStartDateReport.editText!!.setOnClickListener { initStartDateReportSave() }
        initCheckActiveBtnVacationRegistration(
            tlTypeOfReport,
            tlStartDateReport,
            tlDescription,
            btnVacationRegistration
        )
        bottomSheetDialogAdd.setOnKeyListener(this::onKeyBottomSheetDialogAdd)
    }

    private fun initPositiveButtonEdit(
        prnHour: PersianNumberPicker,
        prnMin: PersianNumberPicker,
        dateModel: DateModel
    ) {
        bottomSheetDialogTime.dismiss()
        val calendar = Calendar.getInstance()
        calendar.time = dateModel.result_time_date.gregorianDate
        calendar[Calendar.HOUR_OF_DAY] = prnHour.value
        calendar[Calendar.MINUTE] = prnMin.value
        val date = calendar.time
        val currentTime = report.dateReport
        report.dateReport = date.time
        bottomSheetDialogAdd =
            BottomSheetDialog(AppOfficialOrinab.activity, R.style.BottomSheetDialogTheme)
        @SuppressLint("InflateParams") val viewSheet: View =
            layoutInflater.inflate(R.layout.bottom_sheet_report, null)
        bottomSheetDialogAdd.setContentView(viewSheet)
        bottomSheetDialogAdd.setCanceledOnTouchOutside(false)
        bottomSheetDialogAdd.setCancelable(false)
        bottomSheetDialogAdd.show()
        bottomSheetDialogAdd.setOnDismissListener {}
        val tlTypeOfReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlTypeOfReport)!!
        val tlStartDateReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateReport)!!
        val tlStartDateRegister =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateRegister)!!
        val tlDescription = bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlDescription)!!
        val btnVacationRegistration =
            bottomSheetDialogAdd.findViewById<MaterialButton>(R.id.btnVacationRegistration)!!
        tlTypeOfReport.editText!!.setText(report.type)
        tlDescription.editText!!.setText(report.desc)
        tlTypeOfReport.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                report.type = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        tlDescription.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                report.desc = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        initCreatedAtDateAndTimeNotMinLong(tlStartDateRegister, report.date)
        initCreatedAtDateAndTimeNotMinLong(tlStartDateReport, report.dateReport)
        btnVacationRegistration.setOnClickListener {
            initEditReport(currentTime, report)
        }
        tlStartDateReport.editText!!.setOnClickListener { initStartDateReportEdit() }
        initCheckActiveBtnVacationRegistration(
            tlTypeOfReport,
            tlStartDateReport,
            tlDescription,
            btnVacationRegistration
        )
        bottomSheetDialogAdd.setOnKeyListener(this::onKeyBottomSheetDialogAdd)
    }

    private fun onKeyBottomSheetDialogTime(
        dialog: DialogInterface?,
        keyCode: Int,
        event: KeyEvent?
    ): Boolean {
        if (event!!.action == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                bottomSheetDialogTime.dismiss()
                return true
            }
        }
        return false
    }

    private fun initSaveReport() {
        bottomSheetDialogAdd.dismiss()
        toastTools.toast(resources.getString(R.string.success_save_report))
        if (reportAdapter.getList().isNotEmpty())
            removeNotificationChanel(requireContext(), reportAdapter.getList().first().ids)
        userViewModel.insertReport(report)
        initUpdateList()
        initCheckShowList(
            binding.rcReport,
            binding.lnDataNotFound.lnParent,
            reportAdapter.getList().isEmpty()
        )
        setAlarm(15, report.dateReport)
        report = Report()
    }

    private fun initUpdateList() {
        Handler(Looper.getMainLooper()).postDelayed({
            val result = UserDatabase.getInstance().userDAO().getReportlist()
            initResultReports(result)
        }, 100)
    }


    private fun setAlarm(progress: Int, dateReport: Long) {
        val date = Date(dateReport)
        val newCal = resultCalendar(date)
        addAlarm(
            progress, newCal[Calendar.YEAR],
            newCal[Calendar.MONTH],
            newCal[Calendar.HOUR_OF_DAY],
            newCal[Calendar.MINUTE],
        )
    }

    private fun initCheckActiveBtnVacationRegistration(
        tlTypeOfReport: TextInputLayout,
        tlStartDateReport: TextInputLayout,
        tlDescription: TextInputLayout,
        btnVacationRegistration: MaterialButton
    ) {
        val resultTypeOfLeave = isValidEmptyTextWatcher(tlTypeOfReport)
        val resultStartDate = isValidEmptyTextWatcher(tlStartDateReport)
        val resultDescription = isValidEmptyTextWatcher(tlDescription)
        val result = resultTypeOfLeave && resultStartDate && resultDescription
        when {
            result -> initActiveBtnVacationRegistration(btnVacationRegistration)
            else -> initDeActiveBtnVacationRegistration(btnVacationRegistration)
        }
    }

    private fun initDeActiveBtnVacationRegistration(btnVacationRegistration: MaterialButton) {
        btnVacationRegistration.isEnabled = false
        btnVacationRegistration.setTextColor(resources.getColor(R.color.secondary_text))
        btnVacationRegistration.backgroundTintList = ContextCompat.getColorStateList(
            requireContext(),
            R.color.color_disable_button
        )
        btnVacationRegistration.strokeColor = ContextCompat.getColorStateList(
            requireContext(),
            R.color.color_disable_button
        )
    }

    private fun initActiveBtnVacationRegistration(btnVacationRegistration: MaterialButton) {
        btnVacationRegistration.isEnabled = true
        btnVacationRegistration.setTextColor(resources.getColor(R.color.white))
        btnVacationRegistration.backgroundTintList = ContextCompat.getColorStateList(
            requireContext(),
            R.color.accent
        )
        btnVacationRegistration.strokeColor = ContextCompat.getColorStateList(
            requireContext(),
            R.color.accent
        )
    }

    private fun onKeyBottomSheetDialogAdd(
        dialog: DialogInterface?,
        keyCode: Int,
        event: KeyEvent?
    ): Boolean {
        if (event!!.action == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                bottomSheetDialogAdd.dismiss()
                return true
            }
        }
        return false
    }

    private fun initOnBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    navController.popBackStack()
                }
            })
    }

    private fun initAdapter() {
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            gridLayoutCountManager.getColumnWidth()
        )
        binding.rcReport.layoutManager = gridLayoutManager
        binding.rcReport.setHasFixedSize(true)
        binding.rcReport.adapter = reportAdapter
        reportAdapter.setOnClickListener(object : OnClickListenerAnyAndPosition {
            override fun onClickListenerAnyAndPosition(any: Any, position: Int) =
                initReportOnClickListener(any, position)
        })
        binding.rcReport.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    binding.fabAdd.show()
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 || dy < 0 && binding.fabAdd.isShown) {
                    binding.fabAdd.hide()
                }
            }
        })
        userViewModel.getReports().observe(viewLifecycleOwner, this::initResultReports)
    }

    private fun initReportOnClickListener(any: Any, id: Int) {
        when (id) {
            R.id.switchState -> initSwitchState(any)
            R.id.imgBtnEdit -> initEdit(any)
            R.id.imgBtnRemove -> initRemove(any)
        }
    }

    private fun initRemove(any: Any) {
        val report: Report = any as Report
        userViewModel.deleteItemReport(report.ids)
        reportAdapter.daleteList(report)
        removeAlarm(report)
        initCheckShowList(
            binding.rcReport,
            binding.lnDataNotFound.lnParent,
            reportAdapter.getList().isEmpty()
        )
    }

    private fun removeAlarm(report: Report) {
        val alarmList = ArrayList(alarmViewModel.getAlarmList())
        alarmList.forEach { initResultRemove(it, report) }
    }

    private fun initResultRemove(it: AlarmData?, report: Report) {
        if (it != null) {
            val userDate = initResultCreatedAtDateLong(it.time.time.time)
            val userTime = initResultCreatedAtTimeLong(it.time.time.time)
            val resultDate = initResultCreatedAtDateLong(report.dateReport)
            val resultTime = initResultCreatedAtTimeLong(report.dateReport)
            if (userDate == resultDate && userTime == resultTime)
                alarmViewModel.deleteAlarmResponseLiveData(it)
        }
    }

    private fun initEdit(any: Any) {
        val report: Report = any as Report
        initEditItem(report)
    }

    private fun initEditItem(item: Report) {
        report = item
        report.userId = initUser()!!.id
        report.date = Date().time
        bottomSheetDialogAdd =
            BottomSheetDialog(AppOfficialOrinab.activity, R.style.BottomSheetDialogTheme)
        @SuppressLint("InflateParams") val viewSheet: View =
            layoutInflater.inflate(R.layout.bottom_sheet_report, null)
        bottomSheetDialogAdd.setContentView(viewSheet)
        bottomSheetDialogAdd.setCanceledOnTouchOutside(false)
        bottomSheetDialogAdd.setCancelable(false)
        bottomSheetDialogAdd.show()
        bottomSheetDialogAdd.setOnDismissListener {}
        val tlTypeOfReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlTypeOfReport)!!
        val tlStartDateReport =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateReport)!!
        val tlStartDateRegister =
            bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlStartDateRegister)!!
        val tlDescription = bottomSheetDialogAdd.findViewById<TextInputLayout>(R.id.tlDescription)!!
        val btnVacationRegistration =
            bottomSheetDialogAdd.findViewById<MaterialButton>(R.id.btnVacationRegistration)!!
        tlTypeOfReport.editText!!.setText(report.type)
        tlDescription.editText!!.setText(report.desc)
        btnVacationRegistration.text = resources.getString(R.string.edit_report)
        tlTypeOfReport.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                this@ReportFragment.report.type = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        tlDescription.editText!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                this@ReportFragment.report.desc = s.toString()
                initCheckActiveBtnVacationRegistration(
                    tlTypeOfReport,
                    tlStartDateReport,
                    tlDescription,
                    btnVacationRegistration
                )
            }
        })
        initCreatedAtDateAndTimeNotMinLong(tlStartDateRegister, report.date)
        initCreatedAtDateAndTimeNotMinLong(tlStartDateReport, report.dateReport)
        tlStartDateReport.editText!!.setOnClickListener { initStartDateReportEdit() }
        btnVacationRegistration.setOnClickListener { initEditReport(item, report) }
        initCheckActiveBtnVacationRegistration(
            tlTypeOfReport,
            tlStartDateReport,
            tlDescription,
            btnVacationRegistration
        )
        bottomSheetDialogAdd.setOnKeyListener(this::onKeyBottomSheetDialogAdd)
    }

    private fun initEditReport(item: Report, report: Report) {
        bottomSheetDialogAdd.dismiss()
        binding.rcReport.post {
            report.state = 0
            userViewModel.updateReport(report)
            reportAdapter.updateItemList(report)
            initUpdateAlarm(item, report)
        }
        this.report = Report()
    }

    private fun initEditReport(item: Long, report: Report) {
        bottomSheetDialogAdd.dismiss()
        binding.rcReport.post {
            report.state = 0
            userViewModel.updateReport(report)
            reportAdapter.updateItemList(report)
            initUpdateAlarm(item, report)
        }
        this.report = Report()
    }

    private fun initUpdateAlarm(item: Report, report: Report) {
        val oldDate = Date(item.dateReport)
        val newDate = Date(report.dateReport)
        val oldCal = resultCalendar(oldDate)
        val newCal = resultCalendar(newDate)
        alarmViewModel.updateAlarmResponseLiveData(
            oldCal[Calendar.YEAR],
            oldCal[Calendar.MONTH],
            oldCal[Calendar.HOUR_OF_DAY],
            oldCal[Calendar.MINUTE],
            15,
            newCal[Calendar.YEAR],
            newCal[Calendar.MONTH],
            newCal[Calendar.HOUR_OF_DAY],
            newCal[Calendar.MINUTE],
        )
    }

    private fun initUpdateAlarm(item: Long, report: Report) {
        val oldDate = Date(item)
        val newDate = Date(report.dateReport)
        val oldCal = resultCalendar(oldDate)
        val newCal = resultCalendar(newDate)
        alarmViewModel.updateAlarmResponseLiveData(
            oldCal[Calendar.YEAR],
            oldCal[Calendar.MONTH],
            oldCal[Calendar.HOUR_OF_DAY],
            oldCal[Calendar.MINUTE],
            15,
            newCal[Calendar.YEAR],
            newCal[Calendar.MONTH],
            newCal[Calendar.HOUR_OF_DAY],
            newCal[Calendar.MINUTE],
        )
    }

    private fun resultCalendar(oldDate: Date): Calendar {
        val cal = Calendar.getInstance()
        cal.time = oldDate
        return cal
    }

    private fun initSwitchState(any: Any) {
        binding.rcReport.post {
            val report: Report = any as Report
            userViewModel.updateReport(report)
            reportAdapter.updateItemList(report)
            if (report.state == 1){
                removeAlarm(report)
                removeNotificationChanel(requireContext(),report.ids)
            }
        }
    }

    private fun initResultReports(it: Any) {
        if (it is List<*>) {
            val resultList: List<Report> = it as List<Report>
            val result = resultList.reversed()
            reportAdapter.updateList(result)
            initListReport(result)
            result.forEach {
                if (it.state==1){
                    initCreateNotification(requireContext(), it.ids, it.type, it.desc)
                    return@forEach
                }
            }
        }
    }

    private fun initToolbar() {
        (AppOfficialOrinab.activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        Objects.requireNonNull((AppOfficialOrinab.activity as AppCompatActivity).supportActionBar)
            .setDisplayShowTitleEnabled(false)
        binding.imgBtnBack.setOnClickListener { navController.popBackStack() }
    }

    private fun initNavController() {
        navController =
            Navigation.findNavController(AppOfficialOrinab.activity, R.id.my_nav_fragment)
    }

    private fun addAlarm(
        progress: Int,
        year: Int,
        month: Int,
        numberPickerHours: Int,
        numberPickerMinutes: Int
    ) {
        alarmViewModel.addAlarmResponseLiveData(
            progress, year, month, numberPickerHours, numberPickerMinutes
        )
    }
}