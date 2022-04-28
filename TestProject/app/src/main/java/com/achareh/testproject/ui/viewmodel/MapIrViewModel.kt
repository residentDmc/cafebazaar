package com.achareh.testproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.achareh.testproject.data.repository.MapIrRepository
import com.achareh.testproject.utils.abstracts.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MapIrViewModel(
    private val mapIrRepository: MapIrRepository,
) : BaseViewModel() {

    fun initRevers(lat: String,
                   lon: String): LiveData<Any> {
        val mutableLiveDataVersionApp = MutableLiveData<Any>()
        viewModelScope.launch {
            withContext(Dispatchers.IO) { mapIrRepository.initRevers(lat, lon) }.let(mutableLiveDataVersionApp::postValue)
        }
        return mutableLiveDataVersionApp
    }

}