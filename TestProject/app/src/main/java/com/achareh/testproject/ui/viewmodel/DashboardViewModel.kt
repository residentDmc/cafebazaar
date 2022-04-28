package com.achareh.testproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.achareh.testproject.data.model.request.save_address.RequestSaveAddressModel
import com.achareh.testproject.data.repository.DashboardRepository
import com.achareh.testproject.utils.abstracts.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardViewModel(
    private val dashboardRepository: DashboardRepository,
) : BaseViewModel() {

    fun initAddressList(): LiveData<Any> {
        val mutableLiveDataVersionApp = MutableLiveData<Any>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) { dashboardRepository.initAddressList() }.let(mutableLiveDataVersionApp::postValue)
        }
        return mutableLiveDataVersionApp
    }

    fun initSaveAddress(requestSaveAddressModel: RequestSaveAddressModel): LiveData<Any> {
        val mutableLiveDataVersionApp = MutableLiveData<Any>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) { dashboardRepository.initSaveAddress(requestSaveAddressModel) }.let(mutableLiveDataVersionApp::postValue)
        }
        return mutableLiveDataVersionApp
    }



}