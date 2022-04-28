package com.achareh.testproject.utils.tools

import com.achareh.testproject.R
import com.achareh.testproject.data.model.response.error.ResponseErrorModel
import com.achareh.testproject.utils.application.AppTestProject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.*


class ThrowableTools(private val networkTools: NetworkTools,private val gson: Gson) {

    fun getThrowableError(throwable: Throwable): String {
        return initResultException(throwable)
    }


    private fun initResultException(throwable: Throwable): String {
        return when {
            networkTools.isNetworkAvailable -> AppTestProject.context.getString(R.string.no_connection)
            throwable is UnknownHostException -> AppTestProject.context.getString(R.string.no_connection)
            throwable is HttpException -> initHttpException(throwable)
            throwable is SocketTimeoutException -> AppTestProject.context.getString(R.string.time_out)
            else -> throwable.message.toString()
        }

    }

    private fun initHttpException(throwable: Throwable): String {
        val responseBody = Objects.requireNonNull((throwable as HttpException).response())?.errorBody()
        return try {
            val type = object : TypeToken<ResponseErrorModel?>() {}.type
            val errorModel: ResponseErrorModel =
                gson.fromJson(Objects.requireNonNull(responseBody)!!.charStream(), type)
            errorModel.detail
        } catch (e: Exception) {
            throwable.message!!
        }
    }

}