package com.dev.alarmapplication.data.repository

import com.dev.alarmapplication.data.model.request.location.SaveLocationModel
import com.dev.alarmapplication.data.model.request.login.User
import com.dev.alarmapplication.data.model.response.report.Report
import com.dev.alarmapplication.data.model.response.verification_register_phone.VerificationRegisterPhone
import com.dev.alarmapplication.data.room.UserDatabase


class UserRepository(private val userDatabase: UserDatabase) {

    suspend fun getUser() = userDatabase.userDAO().getUser()
    suspend fun insertUser(user: User) = userDatabase.userDAO().insertUser(user)
    suspend fun updateUser(user: User) = userDatabase.userDAO().updateUser(user)
    suspend fun getUsers() = userDatabase.userDAO().getUsers()
    suspend fun deleteUser() = userDatabase.userDAO().deleteUser()

    suspend fun getReport() = userDatabase.userDAO().getReport()
    suspend fun insertReport(report: Report) = userDatabase.userDAO().insertReport(report)
    suspend fun updateReport(report: Report) = userDatabase.userDAO().updateReport(report)
    suspend fun getReports() = userDatabase.userDAO().getReports()
    suspend fun deleteItemReport(ids:Long) = userDatabase.userDAO().deleteItemReport(ids)
    suspend fun deleteReport() = userDatabase.userDAO().deleteReport()

    suspend fun getSaveLocation() = userDatabase.userDAO().getSaveLocation()
    suspend fun insertSaveLocation(saveLocationModel: SaveLocationModel) = userDatabase.userDAO().insertSaveLocation(saveLocationModel)
    suspend fun updateSaveLocation(saveLocationModel: SaveLocationModel) = userDatabase.userDAO().updateSaveLocation(saveLocationModel)
    suspend fun getSaveLocations() = userDatabase.userDAO().getSaveLocations()
    suspend fun deleteSaveLocation() = userDatabase.userDAO().deleteSaveLocation()
    suspend fun deleteSaveLocationItem(ids:Long) = userDatabase.userDAO().deleteSaveLocationItem(ids)

    suspend fun getVerificationRegisterPhone() = userDatabase.userDAO().getVerificationRegisterPhone()
    fun getVerificationRegisterPhoneLocal() = userDatabase.userDAO().getVerificationRegisterPhoneLocal()
    suspend fun updateVerificationRegisterPhoneLocal(verificationRegisterPhone: VerificationRegisterPhone) = userDatabase.userDAO().updateVerificationRegisterPhoneLocal(verificationRegisterPhone)
    suspend fun insertVerificationRegisterPhone(verificationRegisterPhone: VerificationRegisterPhone) = userDatabase.userDAO().insertVerificationRegisterPhone(verificationRegisterPhone)
    suspend fun deleteVerificationRegisterPhone() = userDatabase.userDAO().deleteVerificationRegisterPhone()

}