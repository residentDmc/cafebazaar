package com.achareh.testproject.ui.view.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.achareh.testproject.R
import com.achareh.testproject.data.model.request.save_address.RequestSaveAddressModel
import com.achareh.testproject.data.model.response.address_list.AddressItem
import com.achareh.testproject.data.model.response.address_map_ir.ResponseAddressMapIrModel
import com.achareh.testproject.databinding.FragmentSaveAddressBinding
import com.achareh.testproject.interfaces.OnClickListenerAny
import com.achareh.testproject.ui.viewmodel.DashboardViewModel
import com.achareh.testproject.utils.application.AppTestProject
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.FEMALE
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.MALE
import com.achareh.testproject.utils.extention.*
import com.achareh.testproject.utils.tools.HandleErrorTools
import com.achareh.testproject.utils.tools.ThrowableTools
import com.achareh.testproject.utils.tools.ToastTools
import org.koin.android.ext.android.inject
import java.util.*

class SaveAddressFragment : Fragment() {


    private lateinit var binding: FragmentSaveAddressBinding
    private lateinit var navController: NavController
    private val dashboardViewModel: DashboardViewModel by inject()
    private val handleErrorTools: HandleErrorTools by inject()
    private val throwableTools: ThrowableTools by inject()
    private val toastTools: ToastTools by inject()
    private val requestSaveAddressModel = RequestSaveAddressModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSaveAddressBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            initAction()
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    private fun initAction() {
        initNavController()
        initToolbar()
        initDefaultGender()
        initAddTextWatcher()
        initOnClick()
        initOnCheckedChange()
        initOnBackPress()
    }

    private fun initNavController() {
        navController =
            Navigation.findNavController(AppTestProject.activity, R.id.my_nav_fragment)
    }

    private fun initToolbar() {
        (AppTestProject.activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
        Objects.requireNonNull((AppTestProject.activity as AppCompatActivity).supportActionBar)!!
            .setDisplayShowTitleEnabled(false)
    }


    private fun initDefaultGender() {
        requestSaveAddressModel.gender=MALE
    }

    private fun initAddTextWatcher() {
        binding.tlName.editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                requestSaveAddressModel.firstName=editable.toString()
                isValidEmptyTextWatcherItem(requireContext(),binding.tlName)
                initCheckActivateLogIn()
            }
        })

        binding.tlFamily.editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                requestSaveAddressModel.lastName=editable.toString()
                isValidEmptyTextWatcherItem(requireContext(),binding.tlFamily)
                initCheckActivateLogIn()
            }
        })

        binding.tlMobile.editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                requestSaveAddressModel.coordinateMobile=editable.toString()
                isValidMobileNumberItem(requireContext(),binding.tlMobile)
                initCheckActivateLogIn()
            }
        })

        binding.tlPhoneNumber.editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                requestSaveAddressModel.coordinatePhoneNumber=editable.toString()
                isValidPhoneNumberItem(requireContext(),binding.tlPhoneNumber)
                initCheckActivateLogIn()
            }
        })
    }

    private fun initCheckActivateLogIn()  {
        val resultName=isValidEmptyTextWatcher(binding.tlName)
        val resultFamily=isValidEmptyTextWatcher(binding.tlFamily)
        val resultMobile=isValidMobileNumber(binding.tlMobile)
        val resultPhoneNumber=isValidPhoneNumber(binding.tlPhoneNumber)
        val resultAddress=isValidEmptyTextWatcher(binding.tlAddress)
        val result=resultName&&resultFamily&&resultMobile&&resultPhoneNumber&&resultAddress
        when {
            result -> initActiveBtnAddressRegister()
            else -> initDeActiveBtnAddressRegister()
        }
    }

    private fun initDeActiveBtnAddressRegister() {
        binding.btnAddressRegister.isEnabled=false
        binding.btnAddressRegister.setTextColor(resources.getColor(R.color.secondary_text))
        binding.btnAddressRegister.backgroundTintList = ContextCompat.getColorStateList(requireContext(),R.color.color_disable_button)
        binding.btnAddressRegister.strokeColor = ContextCompat.getColorStateList(requireContext(),R.color.color_disable_button)
    }

    private fun initActiveBtnAddressRegister() {
        binding.btnAddressRegister.isEnabled=true
        binding.btnAddressRegister.setTextColor(resources.getColor(R.color.white))
        binding.btnAddressRegister.backgroundTintList = ContextCompat.getColorStateList(requireContext(),R.color.accent)
        binding.btnAddressRegister.strokeColor = ContextCompat.getColorStateList(requireContext(),R.color.accent)
    }

    private fun initOnClick() {
        binding.imgBtnBack.setOnClickListener { navController.popBackStack() }
        binding.tlAddress.editText!!.setOnClickListener { initAddAddress() }
        binding.btnAddressRegister.setOnClickListener { initRequestAddress() }
    }

    private fun initOnCheckedChange() {
        binding.radioGroupGender.setOnCheckedChangeListener { _, id -> itemCheckGender(id) }
    }

    private fun itemCheckGender(id: Int) {
        val radioFemaleId=binding.radioFemale.id
        when (id) {
            radioFemaleId -> requestSaveAddressModel.gender= FEMALE
            else -> requestSaveAddressModel.gender= MALE
        }
    }

    private fun initAddAddress() {
        val fragmentManager = requireActivity().supportFragmentManager
        val mapFragment = MapFragment()
        mapFragment.onResult(object : OnClickListenerAny {
            override fun onClickListener(any: Any) {
                initResultAddressInMapBox(any)
            }
        })
        mapFragment.getViewLifecycleOwner(viewLifecycleOwner)
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(
            R.anim.slide_left,
            R.anim.exit_anim,
            R.anim.pop_enter_anim,
            R.anim.slide_right
        )
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.add(android.R.id.content, mapFragment).addToBackStack(null)
            .commit()
    }

    private fun initResultAddressInMapBox(any: Any) {
        val responseAddressMapIrModel: ResponseAddressMapIrModel = any as ResponseAddressMapIrModel
        binding.tlAddress.editText!!.setText(responseAddressMapIrModel.address)
        requestSaveAddressModel.region=1
        requestSaveAddressModel.address=responseAddressMapIrModel.address
        requestSaveAddressModel.lat=responseAddressMapIrModel.geom.coordinates[0].toDouble()
        requestSaveAddressModel.lng=responseAddressMapIrModel.geom.coordinates[1].toDouble()
        initCheckActivateLogIn()
    }


    private fun initRequestAddress() {
        initShowLoading()
        dashboardViewModel.initSaveAddress(requestSaveAddressModel).observe(viewLifecycleOwner, this::initResultSaveAddress)
    }

    private fun initResultSaveAddress(it: Any) {
        initHideLoading()
        when (it) {
            is AddressItem -> initResponseAddressItem()
            is Throwable -> initThrowable(it)
        }
    }

    private fun initResponseAddressItem() {
        toastTools.toast(resources.getString(R.string.registration_completed_successfully))
        navController.popBackStack()
    }

    private fun initThrowable(it: Throwable) {
        val message = throwableTools.getThrowableError(it)
        handleErrorTools.handleError(it)
        toastTools.toast(message)
    }


    private fun initShowLoading() {
        binding.lnProgressAddressRegister.visibility = View.VISIBLE
        binding.btnAddressRegister.visibility = View.GONE
    }

    private fun initHideLoading() {
        binding.btnAddressRegister.visibility = View.GONE
        binding.lnProgressAddressRegister.visibility = View.VISIBLE
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

}