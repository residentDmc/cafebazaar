package com.dev.alarmapplication.utils.extention

import android.content.Context
import android.os.Bundle
import com.google.gson.Gson
import com.dev.alarmapplication.R
import com.dev.alarmapplication.data.model.local.bundle.BundleModel
import com.dev.alarmapplication.data.model.response.account_shaypoor.AccountSheypoor
import com.dev.alarmapplication.data.model.response.arrivals_and_departures.list.ArrivalsAndDepartures
import com.dev.alarmapplication.data.model.response.cabinet_kitchen.Pro
import com.dev.alarmapplication.data.model.response.dashboard.Category
import com.dev.alarmapplication.data.model.response.dashboard.Sub
import com.dev.alarmapplication.data.model.response.get_mobile_number_sheypoor.ResponseMobileNumberSheypoor
import com.dev.alarmapplication.data.model.response.view_all_user.ViewAllUserModel
import com.dev.alarmapplication.data.model.response.view_mile.ViewMileLeave

fun initBundle(context: Context,gson: Gson,key:String,any: Any): Bundle {
    val bundle= Bundle()
    bundle.putString(key,initJsonAny(context,gson,any))
    return bundle
}

fun resultBundle(bundle :Bundle,key:String): String = bundle.getString(key,"")

fun initJsonAny(context: Context,gson: Gson, it: Any): String {
    return when(it){
        is Category-> gson.toJson(BundleModel(it.id,it.url,context.resources.getString(R.string.product_description)))
        is Sub -> gson.toJson(BundleModel(it.id,"",it.title))
        is Pro -> gson.toJson(BundleModel(it.id,it.url,context.resources.getString(R.string.product_description)))
        is AccountSheypoor -> gson.toJson(it)
        is ResponseMobileNumberSheypoor -> gson.toJson(it)
        is ArrivalsAndDepartures -> gson.toJson(it)
        is ViewAllUserModel -> gson.toJson(it)
        is List<*> -> gson.toJson(it)
        is String -> it
        else -> ""
    }
}
