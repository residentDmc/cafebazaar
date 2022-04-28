package com.achareh.testproject.ui.view.fragment

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LifecycleOwner
import com.achareh.testproject.R
import com.achareh.testproject.data.model.response.address_map_ir.ResponseAddressMapIrModel
import com.achareh.testproject.databinding.FragmentMapBinding
import com.achareh.testproject.interfaces.OnClickListenerAny
import com.achareh.testproject.ui.viewmodel.MapIrViewModel
import com.achareh.testproject.utils.application.AppTestProject
import com.achareh.testproject.utils.build_config.BuildConfig.Companion.STYLE_MAP_BOX
import com.achareh.testproject.utils.custom_view.MapFragmentWrapper
import com.achareh.testproject.utils.tools.HandleErrorTools
import com.achareh.testproject.utils.tools.ThrowableTools
import com.achareh.testproject.utils.tools.ToastTools
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions
import com.mapbox.mapboxsdk.location.LocationComponentOptions
import com.mapbox.mapboxsdk.location.modes.CameraMode
import com.mapbox.mapboxsdk.location.modes.RenderMode
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback
import com.mapbox.mapboxsdk.maps.Style
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : DialogFragment(), OnMapReadyCallback, PermissionsListener , View.OnKeyListener {

    private lateinit var binding: FragmentMapBinding
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private lateinit var onClickListenerAny: OnClickListenerAny
    private lateinit var lifecycleOwner: LifecycleOwner
    private lateinit var mapboxMap: MapboxMap
    private lateinit var style: Style
    private lateinit var responseAddressMapIrModel: ResponseAddressMapIrModel
    private var permissionsManager: PermissionsManager = PermissionsManager(this)
    private val handleErrorTools: HandleErrorTools by inject()
    private val throwableTools: ThrowableTools by inject()
    private val toastTools: ToastTools by inject()
    private val mapIrViewModel: MapIrViewModel by viewModel()

    fun onResult(onClickListenerAny: OnClickListenerAny) {
        this.onClickListenerAny = onClickListenerAny
    }

    fun getViewLifecycleOwner(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
    }

    override fun getTheme(): Int {
        return R.style.MyThemes
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMapBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            initOnDismiss(view)
            initMapBox()
        } catch (e: Exception) {
            handleErrorTools.handleError(e)
        }
    }

    private fun initOnDismiss(view: View) {
        view.isFocusableInTouchMode = true
        view.requestFocus()
        view.setOnKeyListener(this)
    }

    @SuppressLint("WrongConstant")
    private fun initMapBox() {
        binding.mapView.getMapAsync(this)
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    @SuppressLint("WrongConstant")
    override fun onMapReady(mapboxMap: MapboxMap) {
        this.mapboxMap = mapboxMap
        initConfig(mapboxMap)
        mapboxMap.setStyle(
            Style.Builder().fromUri(
                STYLE_MAP_BOX
            )
        ) {
            this.style = it
            initMapReady(it)
        }
    }


    private fun initMapReady(it: Style) {
        enableLocationComponent(it)
        initOnDragListener()
        initOnClick()
        initOnBackPress()
    }

    private fun initOnBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                   dismiss()
                }
            })
    }

    private fun initOnDragListener() {
        binding.mapWrapper.setOnDragListener(object : MapFragmentWrapper.OnDragListener {

            override fun onDragStart() {
                binding.btnConfirmation.visibility=View.GONE
            }

            override fun onDragEnd() {
                initMapIrViewModel()
            }

            override fun onStartMap() {
                Handler(Looper.getMainLooper()).postDelayed({
                    initMapIrViewModel()
                }, 500)
            }
        })
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun initOnClick() {
        binding.btnConfirmation.setOnClickListener { initAddress() }
    }

    private fun initAddress() {
        bottomSheetDialog =
            BottomSheetDialog(requireActivity(), R.style.BottomSheetDialogTheme)
        @SuppressLint("InflateParams") val viewSheet: View =
            layoutInflater.inflate(R.layout.bottom_sheet_address, null)
        bottomSheetDialog.setContentView(viewSheet)
        bottomSheetDialog.setCanceledOnTouchOutside(false)
        bottomSheetDialog.setCancelable(false)
        bottomSheetDialog.show()
        bottomSheetDialog.setOnDismissListener {}
        val tlAddress = bottomSheetDialog.findViewById<TextInputLayout>(R.id.tlAddress)!!
        val btnConfirmation = bottomSheetDialog.findViewById<MaterialButton>(R.id.btnConfirmation)!!
        initActionAddress(
            tlAddress,
            btnConfirmation,
        )
        bottomSheetDialog.setOnKeyListener(this::onKeyBottomSheetDialog)
    }

    private fun initActionAddress(
        tlAddress: TextInputLayout,
        btnConfirmation: MaterialButton,
    ) {
        tlAddress.editText!!.setText(responseAddressMapIrModel.address)
        btnConfirmation.setOnClickListener { initResultAddress() }
    }

    private fun initResultAddress() {
        bottomSheetDialog.dismiss()
        onClickListenerAny.onClickListener(responseAddressMapIrModel)
        dismiss()
    }

    private fun onKeyBottomSheetDialog(
        dialog: DialogInterface?,
        keyCode: Int,
        event: KeyEvent?
    ): Boolean {
        if (event!!.action == KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                bottomSheetDialog.dismiss()
                return true
            }
        }
        return false
    }

    private fun initConfig(mapboxMap: MapboxMap) {
        mapboxMap.uiSettings.isAttributionEnabled = false
        mapboxMap.uiSettings.isLogoEnabled = false
        mapboxMap.uiSettings.isRotateGesturesEnabled = false
    }

    @SuppressLint("MissingPermission")
    private fun enableLocationComponent(loadedMapStyle: Style) {
        if (PermissionsManager.areLocationPermissionsGranted(requireContext())) {
            val customLocationComponentOptions = LocationComponentOptions.builder(requireContext())
                .trackingGesturesManagement(true)
                .accuracyColor(ContextCompat.getColor(requireContext(), R.color.accent))
                .build()

            val locationComponentActivationOptions =
                LocationComponentActivationOptions.builder(requireContext(), loadedMapStyle)
                    .locationComponentOptions(customLocationComponentOptions)
                    .build()

            mapboxMap.locationComponent.apply {
                activateLocationComponent(locationComponentActivationOptions)
                isLocationComponentEnabled = true
                cameraMode = CameraMode.TRACKING_GPS
                renderMode = RenderMode.COMPASS
                Handler(Looper.getMainLooper()).postDelayed({ initMapIrViewModel() }, 3000)
            }
        } else {
            permissionsManager = PermissionsManager(this)
            permissionsManager.requestLocationPermissions(requireActivity())
        }
    }

    private fun initMapIrViewModel() {
        try {
            mapIrViewModel.initRevers(
                mapboxMap.cameraPosition.target.latitude.toString(),
                mapboxMap.cameraPosition.target.longitude.toString()
            ).observe(
                viewLifecycleOwner,
                this::initResponseTravelCost
            )
        }catch (e:java.lang.Exception){
            handleErrorTools.handleError(e)
        }
    }

    private fun initResponseTravelCost(it: Any) {
        when (it) {
            is ResponseAddressMapIrModel -> initAddressMapIrModel(it)
            is Throwable -> initThrowable(it)
        }
    }

    private fun initAddressMapIrModel(it: ResponseAddressMapIrModel) {
        responseAddressMapIrModel = it
        binding.btnConfirmation.visibility = View.VISIBLE
    }

    private fun initThrowable(it: Throwable) {
        binding.btnConfirmation.visibility = View.GONE
        val message = throwableTools.getThrowableError(it)
        handleErrorTools.handleError(it)
        toastTools.toast(message)
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onExplanationNeeded(permissionsToExplain: List<String>) {
        toastTools.toast(resources.getString(R.string.user_location_permission_explanation))
    }

    override fun onPermissionResult(granted: Boolean) {
        if (granted) {
            enableLocationComponent(mapboxMap.style!!)
        } else {
            toastTools.toast(resources.getString(R.string.user_location_permission_not_granted))
            AppTestProject.activity.finishAffinity()
        }
    }

    override fun onKey(view: View?, keyCode: Int, keyEvent: KeyEvent): Boolean {
        if (keyEvent.action == KeyEvent.ACTION_DOWN) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                dismiss()
                return true
            }
        }
        return false
    }

}