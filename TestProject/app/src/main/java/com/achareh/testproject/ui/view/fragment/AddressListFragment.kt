package com.achareh.testproject.ui.view.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.achareh.testproject.R
import com.achareh.testproject.data.model.response.address_list.ResponseAddressListModel
import com.achareh.testproject.databinding.FragmentAddressListBinding
import com.achareh.testproject.ui.view.adapter.address.AddressAdapter
import com.achareh.testproject.ui.viewmodel.DashboardViewModel
import com.achareh.testproject.utils.application.AppTestProject
import com.achareh.testproject.utils.extention.initCheckShowList
import com.achareh.testproject.utils.manager.GridLayoutCountManager
import com.achareh.testproject.utils.tools.HandleErrorTools
import com.achareh.testproject.utils.tools.ThrowableTools
import com.achareh.testproject.utils.tools.ToastTools
import org.koin.android.ext.android.inject
import java.util.*


class AddressListFragment : Fragment() {

    private lateinit var binding: FragmentAddressListBinding
    private lateinit var navController: NavController
    private val dashboardViewModel: DashboardViewModel by inject()
    private val handleErrorTools: HandleErrorTools by inject()
    private val gridLayoutCountManager: GridLayoutCountManager by inject()
    private val throwableTools: ThrowableTools by inject()
    private val toastTools: ToastTools by inject()
    private val addressAdapter: AddressAdapter by inject()
    private var doubleBackToExitPressedOnce = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddressListBinding.inflate(layoutInflater)
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
        initOnClick()
        initAdapter()
        initRequestAddress()
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

    private fun initOnClick() {
        binding.fabAdd.setOnClickListener { initAddAddress() }
    }

    private fun initAddAddress() {
        navController.navigate(R.id.action_addressListFragment_to_saveAddressFragment)
    }

    private fun initAdapter() {
        val gridLayoutManager = GridLayoutManager(
            requireContext(),
            gridLayoutCountManager.getColumnWidth()
        )
        binding.rcAddress.layoutManager = gridLayoutManager
        binding.rcAddress.setHasFixedSize(true)
        binding.rcAddress.adapter = addressAdapter
        binding.rcAddress.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) =
                initCheckHideFab(dy)
        })
    }

    private fun initCheckHideFab(dy: Int) {
        if (dy > 0) {
            if (binding.fabAdd.isShown) binding.fabAdd.hide()
        } else if (dy < 0 && !binding.fabAdd.isShown) binding.fabAdd.show()
    }


    private fun initRequestAddress() {
        initShowLoading()
        dashboardViewModel.initAddressList().observe(viewLifecycleOwner, this::initResultAddress)
    }

    private fun initResultAddress(it: Any) {
        initHideLoading()
        when (it) {
            is ResponseAddressListModel -> initResponseAddressListModel(it)
            is Throwable -> initThrowable(it)
        }
    }

    private fun initResponseAddressListModel(it: ResponseAddressListModel) {
        addressAdapter.updateList(it)
        initCheckShowList(
            binding.rcAddress,
            binding.lnDataNotFound.lnParent,
            it.isEmpty()
        )
    }

    private fun initThrowable(it: Throwable) {
        val message = throwableTools.getThrowableError(it)
        handleErrorTools.handleError(it)
        toastTools.toast(message)
    }


    private fun initShowLoading() {
        binding.vLoading.visibility = View.VISIBLE
        binding.rcAddress.visibility = View.GONE
        binding.fabAdd.visibility = View.GONE
    }

    private fun initHideLoading() {
        binding.vLoading.visibility = View.GONE
        binding.rcAddress.visibility = View.VISIBLE
        binding.fabAdd.visibility = View.VISIBLE
    }

    private fun initOnBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    initFinish()
                }
            })
    }

    private fun initFinish() {
        if (doubleBackToExitPressedOnce) {
            requireActivity().finish()
        } else toastTools.toast(resources.getString(R.string.exit_app))
        doubleBackToExitPressedOnce = true
        Handler().postDelayed({
            doubleBackToExitPressedOnce = false
        }, 2000)
    }
}