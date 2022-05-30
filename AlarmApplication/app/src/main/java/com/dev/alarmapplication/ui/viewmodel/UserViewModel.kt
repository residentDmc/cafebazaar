package com.dev.alarmapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev.alarmapplication.data.model.request.location.SaveLocationModel
import com.dev.alarmapplication.data.model.request.login.User
import com.dev.alarmapplication.data.model.response.report.Report
import com.dev.alarmapplication.data.model.response.verification_register_phone.VerificationRegisterPhone
import com.dev.alarmapplication.data.repository.UserRepository
import com.dev.alarmapplication.utils.abstracts.BaseViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(
    private val userRepository: UserRepository,
) : BaseViewModel() {

    private val mutableLiveData = MutableLiveData<Any>()

    fun getUser(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getUser() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun getUsers(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getUsers() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun delete(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.deleteUser() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun insertUser(user: User): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.insertUser(user) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun updateUser(user: User): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.updateUser(user) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }


    fun getReport(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getReport() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun getReports(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getReports() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun deleteItemReport(ids:Long): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.deleteItemReport(ids) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun deleteReport(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.deleteReport() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun insertReport(report: Report): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.insertReport(report) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun updateReport(report: Report): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.updateReport(report) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }


    fun getSaveLocation(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getSaveLocation() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun getSaveLocations(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getSaveLocations() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun deleteSaveLocation(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.deleteSaveLocation() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun deleteSaveLocationItem(ids:Long): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.deleteSaveLocationItem(ids) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun insertSaveLocation(saveLocationModel: SaveLocationModel): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.insertSaveLocation(saveLocationModel) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun updateSaveLocation(saveLocationModel: SaveLocationModel): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.updateSaveLocation(saveLocationModel) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }




    fun getVerificationRegisterPhone(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getVerificationRegisterPhone() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun getVerificationRegisterPhoneLocal(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.getVerificationRegisterPhoneLocal() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun updateVerificationRegisterPhoneLocal(verificationRegisterPhone: VerificationRegisterPhone): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.updateVerificationRegisterPhoneLocal(verificationRegisterPhone) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun insertVerificationRegisterPhone(verificationRegisterPhone: VerificationRegisterPhone): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.insertVerificationRegisterPhone(verificationRegisterPhone) }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

    fun deleteVerificationRegisterPhone(): LiveData<Any> {
        viewModelScope.launch {
            withContext(IO) { userRepository.deleteVerificationRegisterPhone() }.let(mutableLiveData::postValue)
        }
        return mutableLiveData
    }

}