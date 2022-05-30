package com.dev.alarmapplication.data.room

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.dev.alarmapplication.data.model.request.location.SaveLocationModel
import com.dev.alarmapplication.data.model.request.login.User
import com.dev.alarmapplication.data.model.response.report.Report
import com.dev.alarmapplication.data.model.response.verification_register_phone.VerificationRegisterPhone

@Dao
interface UserDAO {

    @Query("select * from user_entity")
    suspend fun getUser(): User?

    @Query("select * from user_entity")
    fun getUserLocal(): User?

    @Query("select * from user_entity")
    suspend fun getUsers(): List<User>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("DELETE FROM user_entity")
    suspend fun deleteUser()




    @Query("select * from user_report")
    suspend fun getReport(): Report?

    @Query("select * from user_report")
    fun getReportLocal(): Report?

    @Query("select * from user_report")
    suspend fun getReports(): List<Report>

    @Query("select * from user_report")
     fun getReportlist(): List<Report>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertReport(report: Report)

    @Update
    suspend fun updateReport(report: Report)

    @Query("DELETE FROM user_report WHERE ids = :ids")
    suspend fun deleteItemReport(ids:Long)

    @Query("DELETE FROM user_report")
    suspend fun deleteReport()





    @Query("select * from save_location")
    suspend fun getSaveLocation(): SaveLocationModel?

    @Query("select * from save_location")
    fun getSaveLocationLocal(): SaveLocationModel?

    @Query("select * from save_location")
    fun getSaveLocationsLocal(): List<SaveLocationModel>

    @Query("select * from save_location")
    suspend fun getSaveLocations(): List<SaveLocationModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSaveLocation(user: SaveLocationModel)

    @Update
    suspend fun updateSaveLocation(user: SaveLocationModel)

    @Query("DELETE FROM save_location")
    suspend fun deleteSaveLocation()

    @Query("DELETE FROM save_location  WHERE ids = :ids")
    suspend fun deleteSaveLocationItem(ids:Long)





    @Query("select * from register_phone_entity")
    suspend fun getVerificationRegisterPhone(): VerificationRegisterPhone?

    @Query("select * from register_phone_entity")
    fun getVerificationRegisterPhoneLocal(): VerificationRegisterPhone?

    @Query("select * from register_phone_entity")
    suspend fun getVerificationRegisterPhones(): List<VerificationRegisterPhone>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVerificationRegisterPhone(user: VerificationRegisterPhone)

    @Update
    suspend fun updateVerificationRegisterPhoneLocal(user: VerificationRegisterPhone)

    @Query("DELETE FROM register_phone_entity")
    suspend fun deleteVerificationRegisterPhone()

}