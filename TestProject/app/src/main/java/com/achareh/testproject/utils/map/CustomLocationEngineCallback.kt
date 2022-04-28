package com.achareh.testproject.utils.map

import android.content.Context
import com.mapbox.android.core.location.LocationEngineCallback
import com.mapbox.android.core.location.LocationEngineResult
import com.achareh.testproject.interfaces.OnClickListenerAny
import java.lang.ref.WeakReference

class CustomLocationEngineCallback(context: Context, private val onClickListenerAny: OnClickListenerAny) :
    LocationEngineCallback<LocationEngineResult> {

    private val activityRef = WeakReference(context)

    override fun onSuccess(result: LocationEngineResult?) {
        try {
            onClickListenerAny.onClickListener(result!!.lastLocation!!)
        }catch (ignore:Exception){ }
    }

    override fun onFailure(exception: Exception) {
        try {
            onClickListenerAny.onClickListener(exception)
        }catch (ignore:Exception){ }
    }
}